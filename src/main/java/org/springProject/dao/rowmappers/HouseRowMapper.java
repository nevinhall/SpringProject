package org.springProject.dao.rowmappers;

import org.springProject.classes.House;
import org.springProject.classes.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseRowMapper implements RowMapper<House> {
    @Override
    public House mapRow(ResultSet resultSet, int i) throws SQLException {
        House house = new House();
        house.setAddress(resultSet.getString("address"));
        house.setEirCode(resultSet.getString("eirCode"));

        return house;

    }
}
