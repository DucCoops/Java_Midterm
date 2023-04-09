package nguyenduc.springcommerce.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nguyenduc.springcommerce.models.Cart;
import nguyenduc.springcommerce.models.OrderDetail;
import nguyenduc.springcommerce.models.OrderDetailID;
import nguyenduc.springcommerce.models.Product;
import nguyenduc.springcommerce.repositories.CartRepo;
import nguyenduc.springcommerce.repositories.OrderDetailIDRepo;
import nguyenduc.springcommerce.repositories.ProductRepo;
import nguyenduc.springcommerce.services.Implement.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private CartServiceImp cartServiceImp;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private OrderDetailIDRepo orderDetailIDRepo;

    @RequestMapping("shop")
    public String index(Model model, HttpServletRequest request){
        List<Product> list = productRepo.findAll();
        model.addAttribute("list", list);
        Cart cart = cartServiceImp.getCart(request);
        model.addAttribute("amount", orderDetailIDRepo.findAllById_CartID(cart.getID()).size());
        return "shop";
    }

    @PostMapping("addToCart")
    public String addToCart(@ModelAttribute("product-id") String id, @ModelAttribute("product-quantity") String quantity, Model model, HttpServletRequest request, HttpServletResponse response){
        Cart tmp = cartServiceImp.getCart(request);
        if(tmp == null){
            boolean check = false;
            for (Cart c: cartRepo.findAll()) {
                if(c.getStatus() == 0){
                    Cookie cartCookie = new Cookie("cart", String.valueOf(c.getID()));
                    cartCookie.setMaxAge(30 * 24 * 60 * 60);
                    response.addCookie(cartCookie);
                    check = true;
                    break;
                }
            }
            if (check == false){
                Cart newCart = new Cart();
                cartRepo.save(newCart);
                Cookie cartCookie = new Cookie("cart", String.valueOf(newCart.getID()));
                cartCookie.setMaxAge(30 * 24 * 60 * 60);
                response.addCookie(cartCookie);
            }

        }

        //Save to Order Detail
        //int cartID = (Integer) session.getAttribute("cart");
        Cart cartID = cartServiceImp.getCart(request);
        double productPrice = productRepo.findProductByProductID(Integer.parseInt(id)).getPrice();
        double total = productPrice * Integer.parseInt(quantity);
        OrderDetailID orderID = new OrderDetailID(cartID.getID(),Integer.parseInt(id));
        OrderDetail order = new OrderDetail(orderID ,total,Integer.parseInt(quantity));


        Cart cart = cartRepo.findCartByID(cartID.getID());
        cart.setPrice(cart.getPrice() + total);
        cartRepo.save(cart);
        orderDetailIDRepo.save(order);
        return "redirect:shop";
    }


}
