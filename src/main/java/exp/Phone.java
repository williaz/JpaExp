package exp;

import exp.Person;

import javax.persistence.*;

/**
 * Created by williaz on 10/4/16.
 * Uni-ManyToOne exp 2.7.1
 * JoinColumn -- FK
 * phone table contain person_id as FK to link person
 */

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "`number`")
    private String number;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person person;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }




}
