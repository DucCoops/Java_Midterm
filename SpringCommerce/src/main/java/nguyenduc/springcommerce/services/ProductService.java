package nguyenduc.springcommerce.services;

import nguyenduc.springcommerce.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchByTitle(String title);
 }
