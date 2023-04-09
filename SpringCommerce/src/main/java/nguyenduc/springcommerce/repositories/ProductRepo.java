package nguyenduc.springcommerce.repositories;

import nguyenduc.springcommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    List<Product> findAllByTitleContainingIgnoreCase(String Title);
    Product findProductByProductID(Integer id);
}
