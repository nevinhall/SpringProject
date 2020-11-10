package org.springProject.service;

import org.springProject.classes.House;
import org.springProject.classes.Person;
import org.springProject.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImplementation implements PersonService {

    @Autowired
    PersonDao personDao;

    @Override
    public String deleteHero(int personId) {
        int res = personDao.deletePersonID(personId);
        return ("An attempt to delete the user with ID of : " + personId + " was executed with a result of: " + res);
    }

    @Override
    public String avg_age() {
        int res = personDao.avg_age();
        return ("The average age of a Person currently stored in the database is " + res + " years old");
    }

    @Override
    public String countOAP() {
        int res = personDao.countOAP();
        return ("The number of Old Age Pensioners currently stored in the database is " + res);
    }

    @Override
    public String countStudents() {
        int res = personDao.countStudents();
        return ("The number of Students currently stored in the database is " + res);
    }

    public String searchHousehold(String eirCode) {

        House occupantsHouse = personDao.searchHouse(eirCode);
        if (occupantsHouse == null) {
            return "The House you are Searching for doesn't exist, therefore there is no occupants \n";
        }
        List<Person> res = personDao.searchHousehold(eirCode);
        String occupants = "Occupants for House " + occupantsHouse.address + " with an eircode of " + occupantsHouse.eirCode;
        for (int i = 0; i < res.size(); i++) {
            occupants = (occupants + " \nOccupant Number:" + (i + 1) + " " + res.get(i).personId + " " + res.get(i).personName + " " + res.get(i).age + "years old " + res.get(i).occupation + " " + res.get(i).eirCode + "\n");
        }

        return occupants;
    }

    @Override
    public String moveHouse(int personId, String newEirCode) {
        Person personExists = personDao.findPerson(personId);
        House houseExists = personDao.searchHouse(newEirCode);

        if (personExists == null) {
            return "The person in which you are attempting to move into the house with an eircode off " + newEirCode + " does not exist, " +
                    "therefore the requested operation can not be carried out\n";
        } else if (houseExists == null) {
            return "The House you are Searching for doesn't exist, therefore we can not move " + personExists.personName + " in\n";
        } else {
            int res = personDao.updateEirCode(personId, newEirCode);
            if (res == 1) {
                House oldHouse = personDao.searchHouse(personExists.eirCode);
                return "The address for " + personExists.personName + " has successfully been changed from " + oldHouse.address + " to " + houseExists.address;
            } else {
                return "The update failed, please try again";
            }

        }

    }

    @Override
    public String addNewPersonToHouse(String personName, int age, String occupation, String eirCode) {
        House houseExists = personDao.searchHouse(eirCode);
        if (houseExists == null) {
            return "The House with an eircode of " + eirCode + " which does not exists, therefor the opperation has been aborted";

        } else {
            personDao.addNewPerson(personName, age, occupation, eirCode);
            return personName + " has been added. they live in house " + houseExists.address;
        }
    }

    @Override
    public String addNewHouseWPeople(String eirCode, String address, ArrayList<Person> people) {
        House houseExists = personDao.searchHouse(eirCode);
        if (houseExists != null) {
            return "You can not add this house, the eircode of " + eirCode + "is all ready present in the database";
        }

        int res = personDao.addHouse(eirCode, address);
        if (res == 1) {

            for (Person person : people) {
                int i = 0;
                int populateHouse = personDao.addNewPerson(person.personName, person.age, person.occupation, eirCode);
                if (populateHouse == 0) {
                    return "unable to populate house, the house has been added to the database";
                }

            }

            return "Operation success";


        }

        return "unable to create house, the opertation has therefore been aborted.";
    }


}




