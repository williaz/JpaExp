package dao;

import domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by williaz on 10/3/16.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
