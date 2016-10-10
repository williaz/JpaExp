package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by williaz on 9/29/16.
 * Order tak charge of Invoice's lefe
 */
@Entity(name = "ORDERS")
public class Order implements Serializable{

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

//    @Column(name = "CUST_ID")/// add field customer
//    private long custId;

    @Column(name = "TOTAL_PRICE", precision = 2)
    private double totPrice;

    @Column(name = "OREDER_DESC")
    private String orderDesc;

    @Column(name = "ORDER_DATE")
    private Date orderDt;

    @OneToOne(optional = false, cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY,
            mappedBy = "order", targetEntity = Invoice.class)
    private Invoice invoice;


    @ManyToOne(optional=false)
    @JoinColumn(name="CUST_ID",referencedColumnName="CUST_ID")
    private Customer customer;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    //org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch multiple bags:
    //the problem is that the JPA annotations are parsed not to allow more than 2 eagerly loaded collection.
    private List<OrderDetail> products= new ArrayList<>();

    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;

    public Order( double totPrice, String orderDesc, Date orderDt) {

        this.totPrice = totPrice;
        this.orderDesc = orderDesc;
        this.orderDt = orderDt;
    }

    public Order() {
    }//!!!hibernate: InstantiationException: No default constructor for entity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return orderId == order.orderId;

    }

    @Override
    public int hashCode() {
        return (int) (orderId ^ (orderId >>> 32));
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getOrderId() {
        return orderId;
    }


    public double getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(double totPrice) {
        this.totPrice = totPrice;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public Date getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(Date orderDt) {
        this.orderDt = orderDt;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        invoice.setOrder(this);

        this.invoice = invoice;
    }
    public void removeInvoice(){
        if(this.invoice!=null){
            this.setInvoice(null);
            this.invoice=null;
        }
    }

    public List<OrderDetail> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        OrderDetail orderDetail = new OrderDetail(this, product);
        products.add(orderDetail);
        product.getOrders().add(orderDetail);
    }

    public void removeProduct(Product product){
        OrderDetail orderDetail = new OrderDetail(this, product);
        products.remove(orderDetail);
        product.getOrders().remove(orderDetail);
        orderDetail.setOrder(null);
        orderDetail.setProduct(null);
    }


    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}