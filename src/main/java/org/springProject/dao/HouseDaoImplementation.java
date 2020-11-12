package org.springProject.dao;

import org.springProject.classes.House;
import org.springProject.classes.Person;
import org.springProject.dao.rowmappers.HouseRowMapper;
import org.springProject.dao.rowmappers.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HouseDaoImplementation implements HouseDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

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
    public int updateEirCode(int personId, String eirCode) {
        final String SQL = "UPDATE person set person.eirCode = ? WHERE person.personId = ?";
        int res = jdbcTemplate.update(SQL, new Object[]{eirCode, personId});
        return res;
    }

    @Override
    public int deleteHouse(String eirCode) {
        final String SQL = "DELETE FROM house WHERE house.eirCode = ?";
        return jdbcTemplate.update(SQL, new Object[]{eirCode});
    }



}
