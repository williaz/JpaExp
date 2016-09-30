package domain;

import config.RootConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by williaz on 9/29/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional
public class EntityTest {
    @Autowired
    private EntityManagerFactory factory;

    private EntityManager em;

    @Before
    public void setUp(){
       em=factory.createEntityManager();
    }

    @Test
    public void whenValidFactoryAutowiredThenReturnNotNull(){
        assertNotNull(factory);
    }

    @Test
    public void whenSetupEntityanagerSuccessfullyThenReturnNotNull(){
        assertNotNull(em);
    }

    @Test
    public void whenValidCustomerStoredThenReturnContainsTrue(){

        Customer customer=new Customer();
        customer.setFirstName("Bo");
        customer.setLastName("Wang");
        customer.setCustType("RETAIL");

        Address address= new Address();
        address.setStreet("Warren St");
        address.setAppt("141");
        address.setCity("Harrison");
        address.setZipCode("07029");
        customer.setAddress(address);

        em.persist(customer);

        assertTrue(em.contains(customer));


    }


    @After
    public void release(){
        em.close();
    }


}
