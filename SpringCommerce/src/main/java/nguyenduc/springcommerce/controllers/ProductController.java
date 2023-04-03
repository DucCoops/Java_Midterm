package nguyenduc.springcommerce.controllers;

import nguyenduc.springcommerce.models.Product;
import nguyenduc.springcommerce.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepo ProRepo;

    @GetMapping("product_info")
    public String product(@RequestParam("id") Integer id, Model model) {


        Product product= ProRepo.findById(id).get();
        model.addAttribute("product",product);
        return "product_info";
    }
}
