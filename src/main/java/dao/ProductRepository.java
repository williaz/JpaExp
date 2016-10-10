package dao;

import domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by williaz on 10/10/16.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
