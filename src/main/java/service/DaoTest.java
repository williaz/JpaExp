package service;

import exp.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

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
        PhoneDetailsRepository phoneDetailsRepository=context.getBean("phoneDetailsRepository",PhoneDetailsRepository.class);
        Phone3Repository phone3Repository = context.getBean("phone3Repository",Phone3Repository.class);

//        Person1 p1 = new Person1("Bo");
//        Phone1 phone1= new Phone1("1231231234");
//        Phone1 phone2= new Phone1("3213214321");
//
//        p1.getPhones().add(phone1);
//        p1.getPhones().add(phone2);
//
//        person1Repository.save(p1);
        //phone1Repository.findOne(80L);

//        Person2 person = new Person2("Austin");
//        Phone2 phone1 = new Phone2( "123-456-7890" );
//        Phone2 phone2 = new Phone2( "321-654-0987" );
//
//        person.addPhone( phone1 );
//        person.addPhone( phone2 );
//
//        person2Repository.save(person);
//        Person2 p2=person2Repository.findOne(82L);
//        List<Phone2> phs= p2.getPhones();
//        for(Phone2 pp: phs){
//            System.out.println(pp.getNumber());
//        }
//        Phone2 phone2=phone2Repository.findOne(83L);
//        System.out.println(phone2.getPerson().getName());


//        PhoneDetails pd=new PhoneDetails("ATT","G4");
//        phoneDetailsRepository.save(pd);
//        Phone3 p3=new Phone3("7322311234");
//        p3.setDetails(pd);
//        phone3Repository.save(p3);
        Phone3 p3=phone3Repository.findOne(87L);
        System.out.println(p3.getDetails().getProvider());
        phoneDetailsRepository.findOne(86L);





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
