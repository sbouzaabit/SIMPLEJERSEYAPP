package cap.bouygues.service.impl;

import cap.bouygues.DAO.IPersonDao;
import cap.bouygues.model.Person;
import cap.bouygues.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sbouzaab on 01/05/2017.
 */
@Service
//@Transactional
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    public String sayHello(){
        return "Salut from WS !";
    }

    @Override
    public List<Person> getListAllPerson() {
        return personDao.getPersons();
    }

    @Override
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    @Override
    public Person getPersonById(Long id) {
        return personDao.getPersonById(id);
    }

    @Override
    public Person getPersonByName(String name) {
        return personDao.getPersonByName(name);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public void deletePerson(Long id) {
        personDao.deletePerson(id);
    }

}
