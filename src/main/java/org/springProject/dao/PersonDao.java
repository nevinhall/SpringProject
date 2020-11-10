package org.springProject.dao;

import org.springProject.classes.House;
import org.springProject.classes.Person;

import java.util.List;

public interface PersonDao {

    List<Person> searchHousehold(String eirCode);
    House searchHouse(String eirCode);
    Person findPerson(int personId);

    int deletePersonID(int personId);
    int avg_age();
    int countOAP();
    int countStudents();
    int updateEirCode(int personId ,String eirCode);
    int addNewPerson(String personName,int age,String occupation,String eirCode);
    int addHouse(String eirCode, String address);
}
