package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by williaz on 10/10/16.
 * @see: a link entity between Order and Product many to many mapping
 * JPA doesn’t allow building a composite identifier out of multiple @ManyToOne associations
 */
@Entity
@Table(name="Order_Detail")
//Composite-id class must implement Serializable
public class OrderDetail implements Serializable {
    @Id
    @ManyToOne
    private Product product;

    @Id
    @ManyToOne
    private Order order;




    public OrderDetail(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    public OrderDetail() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;

        OrderDetail that = (OrderDetail) o;

        if (!order.equals(that.order)) return false;
        return product.equals(that.product);

    }

    @Override
    public int hashCode() {
        int result = order.hashCode();
        result = 31 * result + product.hashCode();
        return result;
    }



    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
