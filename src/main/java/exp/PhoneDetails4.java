package exp;

import javax.persistence.*;

/**
 * Created by williaz on 10/5/16.
 *
 */
@Entity
public class PhoneDetails4 {
    @Id
    @GeneratedValue
    private Long id;

    private String provider;

    private String technology;

    @OneToOne(fetch = FetchType.EAGER)
    //(fetch = FetchType.LAZY)org.hibernate.LazyInitializationException: could not initialize proxy - no Session
    @JoinColumn(name = "phone_id")
    private Phone4 phone;

    public PhoneDetails4() {
    }

    public PhoneDetails4(String provider, String technology) {
        this.provider = provider;
        this.technology = technology;
    }

    public String getProvider() {
        return provider;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Phone4 getPhone() {
        return phone;
    }

    public void setPhone(Phone4 phone) {
        this.phone = phone;
    }
}
