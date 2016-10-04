package exp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by williaz on 10/4/16.
 */
public class Phone2 {
    @Id
    @GeneratedValue
    private Long id;

    //@NaturalId
    @Column(name = "`number`", unique = true)
    private String number;

    @ManyToOne
    private Person2 person;

    public Phone2() {
    }

    public Phone2(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Person2 getPerson() {
        return person;
    }

    public void setPerson(Person2 person) {
        this.person = person;
    }

}
