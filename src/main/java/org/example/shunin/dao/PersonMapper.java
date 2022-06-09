package org.example.shunin.dao;

import org.example.shunin.models.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper <Person>{
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();
        person.setName(resultSet.getString("name"));
        person.setEmail(resultSet.getString("email"));
        person.setId(resultSet.getInt("id"));
        person.setAdress(resultSet.getString("adress"));
        return person;
    }
}
