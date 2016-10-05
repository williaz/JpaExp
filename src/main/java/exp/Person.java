package exp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by williaz on 10/4/16.
 * Uni ManyToOne exp 2.71
 */
@Entity
public class Person {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    //no phones list

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }
}
