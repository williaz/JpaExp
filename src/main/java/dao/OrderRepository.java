package dao;

import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by williaz on 10/3/16.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
