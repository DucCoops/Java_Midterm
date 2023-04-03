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
public class HomeController {
    @Autowired
    private ProductRepo ProRepo;

    @RequestMapping("/")
    public String index(Model model){
        List<Product> list = ProRepo.findAll();
        model.addAttribute("list", list);
        return "index";
    }

}
