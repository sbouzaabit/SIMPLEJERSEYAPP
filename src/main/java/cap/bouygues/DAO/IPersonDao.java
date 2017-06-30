package cap.bouygues.DAO;

import cap.bouygues.model.Person;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by sbouzaab on 14/09/2016.
 */
public interface IPersonDao {

    void addPerson(Person bean);

    List getPersons();

    Person getPersonById(Long id);
    Person getPersonByName(String name);

    void updatePerson(Person bean);

    void deletePerson(Long id);
}
