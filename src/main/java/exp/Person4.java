package exp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by williaz on 10/5/16.
 */
@Entity
public class Person4 {

        @Id
        @GeneratedValue
        private Long id;

        //@NaturalId
        private String registrationNumber;
        @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        private List<Address4> addresses = new ArrayList<>();

        public Person4() {
        }

        public Person4(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public List<Address4> getAddresses() {
            return addresses;
        }

        public void addAddress(Address4 address) {
            addresses.add( address );
            address.getOwners().add( this );
        }

        public void removeAddress(Address4 address) {
            addresses.remove( address );
            address.getOwners().remove( this );
        }

        @Override
        public boolean equals(Object o) {
            if ( this == o ) {
                return true;
            }
            if ( o == null || getClass() != o.getClass() ) {
                return false;
            }
            Person4 person = (Person4) o;
            return Objects.equals( registrationNumber, person.registrationNumber );
        }

        @Override
        public int hashCode() {
            return Objects.hash( registrationNumber );
        }
}
