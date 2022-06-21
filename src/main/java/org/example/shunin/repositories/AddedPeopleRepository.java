package org.example.shunin.repositories;


import org.example.shunin.models.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddedPeopleRepository extends PagingAndSortingRepository<Person, Integer> {

    List<Person> findAllByAgeLessThan(int age);

}
