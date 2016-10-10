package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by williaz on 9/29/16.
 */
@Entity(name = "ORDER_INVOICE")
public class Invoice implements Serializable{

    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceId;

//    @Column(name = "ORDER_ID")
//    private long orderId;
    //One table has a foreign key column that references
    // the primary key of the associated table.

    @Column(name = "AMOUNT_DUE", precision = 2)
    private double amountDue;

    @Column(name = "DATE_RAISED")
    private Date orderRaisedDt;

    @Column(name = "DATE_SETTLED")
    private Date orderSettledDt;

    @Column(name = "DATE_CANCELLED")
    private Date orderCancelledDt;

    @Version
    @Column(name = "LAST_UPDATED_TIME")
    private Date updatedTime;

    @OneToOne(optional = false)
    //@MapsId  //Persist two entities with shared key (when one entity holds a foreign key to the other) using @MapsId annotation.
    @JoinColumn(name = "ORDER_ID")//FK:foreign Key
    private Order order;

    //


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;

        Invoice invoice = (Invoice) o;

        return invoiceId == invoice.invoiceId;

    }

    @Override
    public int hashCode() {
        return (int) (invoiceId ^ (invoiceId >>> 32));
    }

    public Invoice(double amountDue, Date orderRaisedDt, Date orderSettledDt, Date orderCancelledDt) {
        this.amountDue = amountDue;
        this.orderRaisedDt = orderRaisedDt;
        this.orderSettledDt = orderSettledDt;
        this.orderCancelledDt = orderCancelledDt;

    }

    public Invoice() {
    }

    public long getInvoiceId() {
        return invoiceId;
    }


//    public long getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(long orderId) {
//        this.orderId = orderId;
//    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public Date getOrderRaisedDt() {
        return orderRaisedDt;
    }

    public void setOrderRaisedDt(Date orderRaisedDt) {
        this.orderRaisedDt = orderRaisedDt;
    }

    public Date getOrderSettledDt() {
        return orderSettledDt;
    }

    public void setOrderSettledDt(Date orderSettledDt) {
        this.orderSettledDt = orderSettledDt;
    }

    public Date getOrderCancelledDt() {
        return orderCancelledDt;
    }

    public void setOrderCancelledDt(Date orderCancelledDt) {
        this.orderCancelledDt = orderCancelledDt;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}