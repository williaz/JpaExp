package exp;

import javax.persistence.*;

/**
 * Created by williaz on 10/4/16.
 */
@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone2)) return false;

        Phone2 phone2 = (Phone2) o;

        return number.equals(phone2.number);

    }

    @Override
    public int hashCode() {
        return number.hashCode();
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
