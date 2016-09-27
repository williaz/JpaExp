package Service;

import config.RootConfig;
import config.TransactionManagerConfig;
import domain.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.TransactionManagementConfigurationSelector;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


/**
 * Created by williaz on 9/26/16.
 */
public class DaoTest {

    @Transactional
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        //context.register(RootConfig.class, TransactionManagerConfig.class);
        context.scan("config");
        context.refresh();

        EntityManagerFactory emf=context.getBean("entityManagerFactoryBean", EntityManagerFactory.class);
        EntityManager em=emf.createEntityManager();
        Customer customer=new Customer();
        customer.setFirstName("Charles");
        customer.setLastName("Dickens");
        customer.setCustType("RETAIL");
        customer.setStreet("10 Downing Street");
        customer.setAppt("1");
        customer.setCity("NewYork");
        customer.setZipCode("12345");
        em.persist(customer);

    }
}
