package exp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by williaz on 10/4/16.
 *2.7.2
 * Every bidirectional association must have one owning side only (the child side),
 * the other one being referred to as the inverse (or the mappedBy) side.
 */
@Entity
public class Person2 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(fetch=FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    //if lazy, failed to lazily initialize a collection of role
    //use the JOIN FETCH syntax in your JPQL to explicitly fetch the child collection out.
    // This is some how like EAGER fetching.
    private List<Phone2> phones = new ArrayList<>();

    public Person2() {
    }

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Phone2> getPhones() {
        return phones;
    }

    //Whenever a bidirectional association is formed,
    // the application developer must make sure both sides are in-sync at all times.
    // The addPhone() and removePhone() are utilities methods that synchronize
    // both ends whenever a child element is added or removed.

    public void addPhone(Phone2 phone) {
        phones.add( phone );
        phone.setPerson( this ); //for bi
    }

    public void removePhone(Phone2 phone) {
        phones.remove( phone );
        phone.setPerson( null );
    }
}
