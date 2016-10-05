package exp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by williaz on 10/5/16.
 * Uni-MTM
 * the link table is controlled by the owning side.
 */
@Entity
public class Person3 {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Address> addresses = new ArrayList<>();

    public Person3() {
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
