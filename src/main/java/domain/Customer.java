package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by williaz on 9/26/16.
 */
@Entity(name="CUSTOMER")
public class Customer implements Serializable {
    @Id
    @Column(name="CUS_ID", nullable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custId;

    @Column(name="FIRST_NAME", nullable=false, length = 50)
    private String firstName;
    @Column(name="LAST_NAME", length=50)
    private String lastName;

    private String street;
    @Column(nullable=false)
    private String appt;

    private String city;
    @Column(name="ZIP_CODE", nullable=false)
    private String zipCode;
    @Column(name="CUST_TYPE", nullable=false)
    private String custType;
    @Version
    @Column(name="LAST_UPDATED_TIME",nullable=false)
    private Date updatedTime;

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", appt='" + appt + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", custType='" + custType + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAppt() {
        return appt;
    }

    public void setAppt(String appt) {
        this.appt = appt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
