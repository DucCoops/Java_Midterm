package nguyenduc.springcommerce.repositories;

import nguyenduc.springcommerce.models.OrderDetail;
import nguyenduc.springcommerce.models.OrderDetailID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailIDRepo extends JpaRepository<OrderDetail, OrderDetailID> {
    List<OrderDetail> findAllById_CartID(Integer id);
}
