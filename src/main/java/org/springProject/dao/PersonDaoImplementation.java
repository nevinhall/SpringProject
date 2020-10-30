package org.springProject.dao;

import org.springProject.classes.House;
import org.springProject.classes.Person;
import org.springProject.dao.rowmappers.HouseRowMapper;
import org.springProject.dao.rowmappers.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImplementation implements PersonDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> searchHousehold(String eirCode) {
        return jdbcTemplate.query("SELECT * FROM person WHERE person.eircode = ? ",new Object[]{eirCode} ,new PersonRowMapper());
    }

    @Override
    public House searchHouse(String eirCode) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM house WHERE house.eirCode = ?", new Object[]{eirCode}, new HouseRowMapper());
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public Person findPerson(int personId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM person WHERE person.personId = ?", new Object[]{personId}, new PersonRowMapper());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public int deletePersonID(int personId) {
        final String SQL = "DELETE FROM person WHERE person.personId = ?";
        return jdbcTemplate.update(SQL, new Object[]{personId});
    }

    @Override
    public int avg_age() {
        return jdbcTemplate.queryForObject(" SELECT AVG(age) FROM person;", Integer.class);

    }

    @Override
    public int countOAP() {
        return jdbcTemplate.queryForObject(" SELECT COUNT(*) FROM person WHERE person.age > 65;", Integer.class);
    }

    @Override
    public int countStudents() {
        return jdbcTemplate.queryForObject(" SELECT COUNT(*) FROM person WHERE person.occupation = 'scholar';", Integer.class);
    }

    @Override
    public int updateEirCode(int personId ,String eirCode) {
        final String SQL = "UPDATE person set person.eirCode = ? WHERE person.personId = ?";
        int res = jdbcTemplate.update(SQL, new Object[]{eirCode, personId});
        return res;
    }
}
