package cap.bouygues.service;

import cap.bouygues.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sbouzaab on 01/05/2017.
 */
@Service
public interface IPersonService {

    String sayHello();

    List<Person> getListAllPerson();
    void addPerson(Person person);
    Person getPersonById(Long id);
    Person getPersonByName(String nom);

    void updatePerson(Person person);
    void deletePerson(Long id);


}
