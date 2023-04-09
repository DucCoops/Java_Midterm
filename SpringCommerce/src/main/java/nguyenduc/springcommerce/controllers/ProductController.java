package nguyenduc.springcommerce.controllers;

import jakarta.servlet.http.HttpServletRequest;
import nguyenduc.springcommerce.models.Cart;
import nguyenduc.springcommerce.models.Product;
import nguyenduc.springcommerce.repositories.OrderDetailIDRepo;
import nguyenduc.springcommerce.repositories.ProductRepo;
import nguyenduc.springcommerce.services.Implement.CartServiceImp;
import nguyenduc.springcommerce.services.Implement.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    private CartServiceImp cartServiceImp;

    @Autowired
    private OrderDetailIDRepo orderDetailIDRepo;

    @GetMapping("product_info")
    public String product(@RequestParam("id") Integer id, Model model, HttpServletRequest request) {
        Product product = productRepo.findById(id).get();
        model.addAttribute("product",product);
        Cart cart = cartServiceImp.getCart(request);
        model.addAttribute("amount", orderDetailIDRepo.findAllById_CartID(cart.getID()).size());
        return "product_info";
    }

    @PostMapping("search")
    public String searchByTitle(@ModelAttribute("title")String title, Model model){
        List<Product> products = productServiceImp.searchByTitle(title);
        model.addAttribute("list", products);
        return "shop";
    }

}
