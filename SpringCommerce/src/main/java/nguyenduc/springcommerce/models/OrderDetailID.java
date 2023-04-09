package nguyenduc.springcommerce.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orderdetails")
public class OrderDetailID implements Serializable {
    @Column(name = "cartID")
    private int cartID;

    @Column(name = "productID")
    private int productID;
}
