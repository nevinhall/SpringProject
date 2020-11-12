package org.springProject.dao;

import org.springProject.classes.House;
import org.springProject.classes.Person;

import java.util.List;

public interface HouseDao {
    List<Person> searchHousehold(String eirCode);
    House searchHouse(String eirCode);
    int addHouse(String eirCode, String address);
    int updateEirCode(int personId ,String eirCode);
    int deleteHouse(String eirCode);

}
