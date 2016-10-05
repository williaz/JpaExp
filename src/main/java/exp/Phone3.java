package exp;

import javax.persistence.*;

/**
 * Created by williaz on 10/4/16.
 * 2.7.3
 */
@Entity
public class Phone3 {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`number`")
    private String number;

    @OneToOne
    @JoinColumn(name = "details_id")
    private PhoneDetails details;

    public Phone3() {
    }

    public Phone3(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public PhoneDetails getDetails() {
        return details;
    }

    public void setDetails(PhoneDetails details) {
        this.details = details;
    }
}
