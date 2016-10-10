package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by williaz on 9/26/16.
 * 1. a Customer enjoys a one-to-many relationship with an Order,
 * whereas an Order has a many-to-one relationship with the Customer.
 * 2. Customer take care of order persisting
 */
@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {

    @Id
    @Column(name="CUST_ID", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custId;

    @Column(name="FIRST_NAME", nullable=false, length = 50)
    private String firstName;
    @Column(name="LAST_NAME", length=50)
    private String lastName;



    @Embedded
    private Address address;
    /*
    private String street;
    @Column(nullable=false)
    private String appt;

    private String city;
    @Column(name="ZIP_CODE", nullable=false)
    private String zipCode;
    */
    @Column(name="CUST_TYPE", nullable=false)
    private String custType;
    @Version
    @Column(name="LAST_UPDATED_TIME",nullable=false)
    private Date updatedTime;

    @OneToMany(mappedBy="customer",targetEntity=Order.class,
            cascade = CascadeType.ALL, orphanRemoval = true,
            fetch=FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", custType='" + custType + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        return custId == customer.custId;

    }

    @Override
    public int hashCode() {
        return (int) (custId ^ (custId >>> 32));
    }

    public void addOrder(Order order){
        orders.add(order);
        order.setCustomer(this);
    }

    public void removceOrder(Order order){
        orders.remove(order);
        order.setCustomer(null);

    }

    public List<Order> getOrders() {
        return orders;
    }

    public long getCustId() {
        return custId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
