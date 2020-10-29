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
}
