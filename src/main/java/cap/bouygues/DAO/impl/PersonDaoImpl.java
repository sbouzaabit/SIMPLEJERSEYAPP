package cap.bouygues.DAO.impl;

import cap.bouygues.DAO.IPersonDao;
import cap.bouygues.DAO.SessionUtil;
import cap.bouygues.model.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by sbouzaab on 14/09/2016.
 */
public class PersonDaoImpl implements IPersonDao{

    public void addPerson(Person bean){
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Person p = new Person();

        p.setNom(bean.getNom());
        p.setPrenom(bean.getPrenom());
        p.setEmail(bean.getEmail());
        p.setNumTele(bean.getNumTele());

        session.save(p);
        tx.commit();
        session.close();

    }

    public List getPersons(){
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from Person");
        List persons =  query.list();
        return persons;
    }

   //public int deleteEmployee(int id) {
   //   Session session = SessionUtil.getSession();
   //   Transaction tx = session.beginTransaction();
   //   String hql = "delete from Employee where id = :id";
   //   Query query = session.createQuery(hql);
   //   query.setInteger("id",id);
   //   int rowCount = query.executeUpdate();
   //   System.out.println("Rows affected: " + rowCount);
   //   tx.commit();
   //   session.close();
   //   return rowCount;
   //

    public Person getPersonById(Long id){
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from Person where id= :id");
        query.setParameter("id", id);
        Person p = (Person) query.uniqueResult();
        return p;
    }

    public Person getPersonByName(String name){
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from Person where nom= :name");
        query.setParameter("name", name);
        Person p = (Person) query.uniqueResult();
        return p;
    }

    @Override
    public void updatePerson(Person per) {
        Transaction trns = null;
        Session session = SessionUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(per);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

    }


    @Override
    public void deletePerson(Long id) {
        Transaction trns = null;
        Session session = SessionUtil.getSessionFactory().openSession();
        try {
            Person result = (Person) session.createCriteria(Person.class)
                    .add(Restrictions.idEq(id))
                    .uniqueResult();

            if (result != null)
            {
                session.delete(result);
            }
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }

    }

    /*
     public int updatePerson(Person per){


        Session session = SessionUtil.getSession();
        Query query = session.createQuery("update Person set nom = :personName, prenom = :personFirstname where id = :idPerson");
        query.setParameter("personName", per.getNom());
        query.setParameter("personFirstname", per.getPrenom());
        query.setParameter("idPerson", per.getId());


        int result = query.executeUpdate();
        return result;
    }
    */


}
