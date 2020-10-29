package org.springProject.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImplementation implements PersonDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

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
}
