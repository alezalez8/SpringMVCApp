package org.example.shunin.dao;


import org.example.shunin.models.Person;
import org.example.shunin.repositories.AddedPeopleRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Component
public class PersonDAON {

    private final EntityManager entityManager;
    private final AddedPeopleRepository addedPeopleRepository;

    @Autowired
    public PersonDAON(EntityManager entityManager, AddedPeopleRepository addedPeopleRepository) {
        this.entityManager = entityManager;
        this.addedPeopleRepository = addedPeopleRepository;
    }

    @Transactional(readOnly = true)
    public void testNPlus1() {
        Session session = entityManager.unwrap(Session.class);  // instead of Session session = sessionFactory.get...
/*
        // 1 запрос
        List<Person> people = session.createQuery("select p from Person p", Person.class)
                .getResultList();
        // N запросов к БД
        for (Person person : people
        ) {
            System.out.println("Person " + person.getName() + " has: " + person.getItems());
        }
*/
        /*List<Person> people = entityManager.createQuery("select p from Person p left join fetch p.items")
                .getResultList();*/
        Set<Person> people = new  HashSet<Person>(entityManager.createQuery("select p from Person p left join fetch p.items")
                .getResultList());
        for (Person person : people
        ) {
            System.out.println("Person " + person.getName() + " has: " + person.getItems());
        }

    }
}