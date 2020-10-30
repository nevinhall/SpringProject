package org.springProject.dao.rowmappers;

import org.springProject.classes.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setPersonId(resultSet.getInt("personId"));
        person.setAge(resultSet.getInt("Age"));
        person.setEirCode(resultSet.getString("eirCode"));
        person.setPersonName(resultSet.getString("personName"));
        person.setOccupation(resultSet.getString("occupation"));

        return person;
    }
}
