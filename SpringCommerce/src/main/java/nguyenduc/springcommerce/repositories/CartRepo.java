package nguyenduc.springcommerce.repositories;

import nguyenduc.springcommerce.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Integer> {
    Cart findCartByID(int id);

}
