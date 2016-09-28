package domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by williaz on 9/27/16.
 */
@Embeddable
public class Address implements Serializable {
    private String street;
    @Column(nullable=false)
    private String appt;

    private String city;
    @Column(name="ZIP_CODE", nullable=false)
    private String zipCode;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", appt='" + appt + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
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
}
