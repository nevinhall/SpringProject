package org.springProject.dao;
import org.springProject.classes.Person;

public interface PersonDao {

    Person findPerson(int personId);
    int deletePersonID(int personId);
    int avg_age();
    int countOAP();
    int countStudents();
    int addNewPerson(String personName,int age,String occupation,String eirCode);


}
