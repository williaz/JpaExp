package exp;

import exp.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by williaz on 10/4/16.
 */
public interface PersonRepository extends CrudRepository<Person,Long> {
}
