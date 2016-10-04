package dao;

import config.RootConfig;
import domain.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by williaz on 10/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class DaoTest {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void saveAndFindByOrderId(){
        LocalDate today= LocalDate.now();
        Date dt=java.sql.Date.valueOf(today);
        Order order =new Order(1,100,"meaningwhat",dt);
        Order persistedOrder=orderRepository.save(order);
        long id=persistedOrder.getOrderId();
        persistedOrder=orderRepository.findOne(id);
        Assert.assertEquals(order,persistedOrder);

    }


}
