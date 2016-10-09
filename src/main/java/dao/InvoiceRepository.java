package dao;

import domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by williaz on 10/3/16.
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
