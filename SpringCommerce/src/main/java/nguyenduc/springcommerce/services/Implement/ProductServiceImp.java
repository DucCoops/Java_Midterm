package nguyenduc.springcommerce.services.Implement;

import nguyenduc.springcommerce.models.Product;
import nguyenduc.springcommerce.repositories.ProductRepo;
import nguyenduc.springcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> searchByTitle(String title) {
        return productRepo.findAllByTitleContainingIgnoreCase(title);
    }
}
