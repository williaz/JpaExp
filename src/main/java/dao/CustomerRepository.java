package dao;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by williaz on 10/8/16.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
