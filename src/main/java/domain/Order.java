package domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by williaz on 9/29/16.
 */
@Entity(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ORDER_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    @Column(name = "CUST_ID")
    private long custId;

    @Column(name = "TOTAL_PRICE", precision = 2)
    private double totPrice;

    @Column(name = "OREDER_DESC")
    private String orderDesc;

    @Column(name = "ORDER_DATE")
    private Date orderDt;

    @OneToOne(optional = false, cascade = CascadeType.ALL,
            mappedBy = "order", targetEntity = Invoice.class)
    private Invoice invoice;

    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;

    public Order(long custId, double totPrice, String orderDesc, Date orderDt) {
        this.custId = custId;
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




    public long getOrderId() {
        return orderId;
    }


    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
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
        this.invoice = invoice;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}