package exp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by williaz on 10/4/16.
 *
 * Every bidirectional association must have one owning side only (the child side),
 * the other one being referred to as the inverse (or the mappedBy) side.
 */
@Entity
public class Person2 {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Phone2> phones = new ArrayList<>();

    public Person2() {
    }

    public Person2(String name) {
        this.name = name;
    }

    public List<Phone2> getPhones() {
        return phones;
    }

    public void addPhone(Phone2 phone) {
        phones.add( phone );
        phone.setPerson( this ); //for bi
    }

    public void removePhone(Phone2 phone) {
        phones.remove( phone );
        phone.setPerson( null );
    }
}
