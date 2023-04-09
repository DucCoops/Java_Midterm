package nguyenduc.springcommerce.controllers;

import jakarta.servlet.http.*;
import nguyenduc.springcommerce.models.Cart;
import nguyenduc.springcommerce.models.OrderDetail;
import nguyenduc.springcommerce.models.Product;
import nguyenduc.springcommerce.repositories.CartRepo;
import nguyenduc.springcommerce.repositories.OrderDetailIDRepo;
import nguyenduc.springcommerce.repositories.ProductRepo;
import nguyenduc.springcommerce.services.Implement.CartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private OrderDetailIDRepo orderDetailIDRepo;
    @Autowired
    private CartServiceImp cartServiceImp;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private ProductRepo productRepo;

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response){
        cartServiceImp.createCart(request, response);
        List<Product> list = productRepo.findAll();
        model.addAttribute("list", list);
        Cart cart = cartServiceImp.getCart(request);
        model.addAttribute("amount", orderDetailIDRepo.findAllById_CartID(cart.getID()).size());
        return "index";
    }

    @GetMapping("/success")
    public String success(Model model, HttpServletRequest request, HttpServletResponse response){
        Cart cart = cartServiceImp.getCart(request);
        cart.setStatus(1);
        cartRepo.save(cart);
        cartServiceImp.removeCart(request, response);
        return "success";
    }

    @GetMapping("/premium")
    public String premium(){
        return "premium";
    }


    @GetMapping("/cart")
    public String cart(Model model, HttpServletRequest request){
        Cart cart = cartServiceImp.getCart(request);
        List<OrderDetail> orderDetailList = orderDetailIDRepo.findAllById_CartID(cart.getID());
        List<Product> productList = new ArrayList<>();

        List<String[]> listString = new ArrayList<>();
        for (OrderDetail o: orderDetailList) {
            Product p = productRepo.findProductByProductID(o.getId().getProductID());
            productList.add(p);
            String[] tmp = new String[6];
            tmp[0] = p.getImage();
            tmp[1] = p.getTitle();
            tmp[2] = p.getBrand();
            tmp[3] = String.valueOf(o.getQuantity());
            tmp[4] = String.valueOf(p.getPrice());
            tmp[5] = String.valueOf(o.getPrice());
            listString.add(tmp);
        }

        model.addAttribute("cart", cart);
        model.addAttribute("prolist", productList);
        model.addAttribute("orderlist", orderDetailList);
        model.addAttribute("listString", listString);
        return "cart";
    }


}
