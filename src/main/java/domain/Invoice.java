package domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by williaz on 9/29/16.
 */
@Entity(name = "ORDER_INVOICE")
public class Invoice {

    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceId;

    @Column(name = "ORDER_ID")
    private long orderId;

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
    @JoinColumn(name = "ORDER_ID")
    private Order order;



    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

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