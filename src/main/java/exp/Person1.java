package exp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by williaz on 10/4/16.
 * Uni OneToMany 2.7.2
 * The @OneToMany association links a parent entity with one or more child entities.
 * created person1_phone1 table to store the relationship,
 * no colums in table person1 or phone1 contains info about each other
 * person1 as the parent table, can find its phone1 info
 * phone1 cann't find person1 info
 */
@Entity
public class Person1 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone1> phones = new ArrayList<>();

    public Person1() {
    }

    public Person1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Phone1> getPhones() {
        return phones;
    }
}
