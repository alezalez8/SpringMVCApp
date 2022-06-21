package org.example.shunin.dao;

import org.example.shunin.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;


    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)   // вместо   session.beginTransaction();
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
       return session.createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        Session session = sessionFactory.getCurrentSession();
      /*  Person person = session.createQuery("select p from Person p where p.id=:id",
                Person.class).setParameter("id", id).getResultList().get(0);*/

        return session.get(Person.class, id);
    }

    @Transactional(readOnly = false)
    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Person.class, id));
    }

    @Transactional
    public void update(int id, Person person) {
        Session session = sessionFactory.getCurrentSession();
        Person presentPerson = session.get(Person.class, id);
        presentPerson.setAge(person.getAge());
        presentPerson.setName(person.getName());
        presentPerson.setEmail(person.getEmail());
    }
}
