package dao;

import domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * Created by williaz on 10/3/16.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
