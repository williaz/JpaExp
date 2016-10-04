package exp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by williaz on 10/4/16.
 */
@Entity
public class Phone1 {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`number`")
    private String number;

    public Phone1() {
    }

    public Phone1(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }
}
