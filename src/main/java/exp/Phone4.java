package exp;

import javax.persistence.*;

/**
 * Created by williaz on 10/5/16.
 */
@Entity
public class Phone4 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`number`")
    private String number;

    @OneToOne(mappedBy = "phone", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PhoneDetails4 details;

    public Phone4() {
    }

    public Phone4(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public PhoneDetails4 getDetails() {
        return details;
    }
//take care sync
    public void addDetails(PhoneDetails4 details) {
        details.setPhone( this );
        this.details = details;
    }

    public void removeDetails() {
        if ( details != null ) {
            details.setPhone( null );
            this.details = null;
        }
    }
}
