package service;

import exp.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by williaz on 10/4/16.
 */
public class DaoTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        //context.register(RootConfig.class, TransactionManagerConfig.class);
        context.scan("config");
        context.refresh();

//        OrderRepository orderRepository=context.getBean("orderRepository",OrderRepository.class);
//        InvoiceRepository invoiceRepository=context.getBean("invoiceRepository",InvoiceRepository.class);
//        PersonRepository personRepository=context.getBean("personRepository",PersonRepository.class);
//        PhoneRepository phoneRepository = context.getBean("phoneRepository",PhoneRepository.class);

//        Person person = new Person("William");
//        personRepository.save(person);
//
//        Phone phone1= new Phone("7321231234");
//        phone1.setPerson(person);
//
//        Phone phone2= new Phone("6461231234");
//        phone2.setPerson(person);
//
//        phoneRepository.save(phone1);
//        phoneRepository.save(phone2);
        /*
        Person person2 = new Person("Bill");
        personRepository.save(person2);

        Phone p1=phoneRepository.findOne(73L);
        System.out.println(p1.getNumber());
        p1.setPerson(person2);

        phoneRepository.save(p1);
        */
//        Phone p1=phoneRepository.findOne(73L);
//        System.out.println(p1.getPerson().getName());
        Person1Repository person1Repository=context.getBean("person1Repository",Person1Repository.class);
        Phone1Repository phone1Repository = context.getBean("phone1Repository",Phone1Repository.class);

//        Person1 p1 = new Person1("Bo");
//        Phone1 phone1= new Phone1("1231231234");
//        Phone1 phone2= new Phone1("3213214321");
//
//        p1.getPhones().add(phone1);
//        p1.getPhones().add(phone2);
//
//        person1Repository.save(p1);
        phone1Repository.findOne(80L);







//        LocalDate today= LocalDate.now();
//        Date dt=java.sql.Date.valueOf(today);
        //Order order =new Order(2,555,"xxwexx",dt);
//        Order persistedOrder=orderRepository.save(order);
//        long id=persistedOrder.getOrderId();
//        System.out.println("the id is"+id);

//        Invoice iv=new Invoice(25,dt,dt,dt,order);
//
//        Invoice pIv=invoiceRepository.save(iv);
//        pIv=invoiceRepository.findOne(pIv.getInvoiceId());
//        System.out.println("Print? " + pIv.getAmountDue());

//        System.out.println(orderRepository.exists(70L)+" "+orderRepository.count());
//        Order persistedOrder=orderRepository.findOne(70L);
//        Iterable<Order> orders=orderRepository.findAll();
//        for(Order o:orders) {
//            System.out.println("Print? " + o);
//        }



    }
}
