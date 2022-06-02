package org.example.shunin.dao;

import org.example.shunin.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Bob",52, "bob@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Nike",18, "nike@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Katy",34, "katy@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }


    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);

    }

    public void update(int id, Person person) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(person.getName());
        personToBeUpdate.setAge(person.getAge());
        personToBeUpdate.setEmail(person.getEmail());

    }
}
