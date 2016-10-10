package dao;

import config.RootConfig;
import domain.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * Created by williaz on 10/3/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
@Transactional//rollback default true
public class DaoTest {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    public void Test_PersistProductAndFindById_ExpectedTrue(){
        LocalDate today = LocalDate.now();
        Date dt = java.sql.Date.valueOf(today);
        Product p1 = new Product("Mac 20", "20' macbook3","1500",dt);
        Product p2 = productRepository.save(p1);
        p2 = productRepository.findOne(p2.getProdId());

        Assert.assertNotNull(p2);
    }
    /*
    @Test
    @Transactional
    public void Test_OrderAndProductWithOrderDetalMapping_PersistOrder_ExpectedOrderDetainPersisted(){

        Order order1 = orderRepository.findOne(68L);
        Product p = productRepository.findOne(141L);
        Assert.assertEquals(141L,p.getProdId());
        order1.addProduct(p);
        order1=orderRepository.saveAndFlush(order1);

        OrderDetail orderDetail =new OrderDetail(order1, p);
        Assert.assertEquals(orderDetail.getProduct().getProdId(),141L);

        Assert.assertTrue(order1.getProducts().contains(orderDetail));

    }
    */

    @Test
    @Transactional
    public void Test_OrderAndProductWithOrderDetalMapping_PersistOrder_ExpectedOrderDetainPersisted(){

        Order order1 = orderRepository.findOne(123L);
        Product p = productRepository.findOne(141L);
        Assert.assertEquals(141L,p.getProdId());
        order1.addProduct(p);
        order1=orderRepository.saveAndFlush(order1);

        Assert.assertTrue(order1.getProductList().contains(p));




    }

    @Test
   // @Ignore
    public void saveOrderThenFindCustomerFromOrder(){

//        LocalDate today= LocalDate.now();
//        LocalDate orderRaisedDt=today.plusDays(25L);
//        LocalDate orderSettledDt=today.plusDays(60L);
//        LocalDate orderCancelledDt=today.plusDays(70L);
//
//        Date dt=java.sql.Date.valueOf(today);
//        Date dt1=java.sql.Date.valueOf(orderRaisedDt);
//        Date dt2=java.sql.Date.valueOf(orderSettledDt);
//        Date dt3=java.sql.Date.valueOf(orderCancelledDt);
//
//        Invoice invoice=new Invoice(1000,dt1,dt2,dt3);
//        Order order =new Order(1200,"TV",dt);
//        order.setInvoice(invoice);
//
        Customer customer=customerRepository.findOne(1L);
//        Assert.assertNotNull(customer);
//        customer.addOrder(order);
//        customerRepository.save(customer);

        //customer=customerRepository.findOne(1L);

        List<Order> orders=customer.getOrders();

        Order order=orderRepository.findOne(128L);

        Assert.assertTrue(orders.contains(order));

    }

    @Test
   // @Ignore
    public void saveAndFindByOrderId(){
        LocalDate today= LocalDate.now();
        LocalDate orderRaisedDt=today.plusDays(25L);
        LocalDate orderSettledDt=today.plusDays(60L);
        LocalDate orderCancelledDt=today.plusDays(70L);

        Date dt=java.sql.Date.valueOf(today);
        Date dt1=java.sql.Date.valueOf(orderRaisedDt);
        Date dt2=java.sql.Date.valueOf(orderSettledDt);
        Date dt3=java.sql.Date.valueOf(orderCancelledDt);

        Invoice invoice=new Invoice(25,dt1,dt2,dt3);
        Order order =new Order(600,"an apple iphone7",dt);
        order.setInvoice(invoice);

        Order persistedOrder=orderRepository.save(order);
        Assert.assertEquals(order,persistedOrder);

        long id=persistedOrder.getOrderId();
        persistedOrder=orderRepository.findOne(id);
        Assert.assertEquals(order,persistedOrder);



    }


}
