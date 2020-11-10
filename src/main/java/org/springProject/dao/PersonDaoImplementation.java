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
    public List<Person> searchHousehold(String eirCode) {
        return jdbcTemplate.query("SELECT * FROM person WHERE person.eircode = ? ", new Object[]{eirCode}, new PersonRowMapper());
    }

    @Override
    public House searchHouse(String eirCode) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM house WHERE house.eirCode = ?", new Object[]{eirCode}, new HouseRowMapper());
        } catch (Exception e) {
            return null;
        }

    }

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
    public int updateEirCode(int personId, String eirCode) {
        final String SQL = "UPDATE person set person.eirCode = ? WHERE person.personId = ?";
        int res = jdbcTemplate.update(SQL, new Object[]{eirCode, personId});
        return res;
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

    @Override
    public int addHouse(String eirCode, String address) {
        final String INSERT_SQL = "INSERT INTO house(eirCode,address) VALUES (?,?)";

        int res = jdbcTemplate.update(
                new PreparedStatementCreator() {

                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[]{"eirCode"});
                        ps.setString(1, eirCode);
                        ps.setString(2, address);
                        return ps;
                    }
                });
        return res;
    }

}
