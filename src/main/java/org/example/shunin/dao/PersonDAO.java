package org.example.shunin.dao;

import org.example.shunin.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {

    private final SessionFactory sessionFactory;


    @Autowired
    public PersonDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional   // вместо   session.beginTransaction();
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> people = new ArrayList<>();


        return null;
    }

    public Person show(int id) {
        return null;
    }

    public void save(Person person) {

    }


    public void delete(int id) {
    }

    public void update(int id, Person person) {

    }
}
