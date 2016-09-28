package Service;

import domain.Address;
import domain.Customer;
import oracle.net.resolver.AddrResolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SQLOutputImpl;


/**
 * Created by williaz on 9/26/16.
 */

public class DaoTest {



    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        //context.register(RootConfig.class, TransactionManagerConfig.class);
        context.scan("config");
        context.refresh();


        EntityManagerFactory emf=context.getBean("entityManagerFactoryBean", EntityManagerFactory.class);
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();

        tx.begin();
        Customer customer=new Customer();
        customer.setFirstName("Will");
        customer.setLastName("Wang");
        customer.setCustType("RETAIL");

        Address address= new Address();
        address.setStreet("Stonehedge Rd");
        address.setAppt("2901");
        address.setCity("Edison");
        address.setZipCode("08820");
        customer.setAddress(address);

        em.persist(customer);
        tx.commit();

        em.close();
        emf.close();



    }
}
