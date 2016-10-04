package dao;

import domain.Invoice;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by williaz on 10/3/16.
 */
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    Invoice findByOrderId(long orderId);
}
