package org.springProject.dao;

import org.springProject.classes.House;
import org.springProject.classes.Person;

import java.util.List;

public interface PersonDao {

    List<Person> searchHousehold(String eirCode);
    House searchHouse(String eirCode);

    int deletePersonID(int personId);
    int avg_age();
    int countOAP();
    int countStudents();
}
