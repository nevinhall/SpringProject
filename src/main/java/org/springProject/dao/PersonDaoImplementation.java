package org.springProject.dao;

import org.springProject.classes.House;
import org.springProject.classes.Person;
import org.springProject.dao.rowmappers.HouseRowMapper;
import org.springProject.dao.rowmappers.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDaoImplementation implements PersonDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public Person findPerson(int personId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM person WHERE person.personId = ?", new Object[]{personId}, new PersonRowMapper());
        } catch (Exception e) {
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
    public int addNewPerson(String personName, int age, String occupation, String eirCode) {
        final String INSERT_SQL = "INSERT INTO person( personName,age, occupation, eirCode) VALUES (?,?,?,?)";
        KeyHolder KeyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(
                new PreparedStatementCreator() {

                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"personId"});
                        ps.setString(1, personName);
                        ps.setInt(2, age);
                        ps.setString(3, occupation);
                        ps.setString(4, eirCode);
                        return ps;
                    }
                }, KeyHolder);

        return KeyHolder.getKey().intValue();
    }



}
