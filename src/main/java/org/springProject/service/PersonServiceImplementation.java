package org.springProject.service;

import org.springProject.classes.House;
import org.springProject.classes.Person;
import org.springProject.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        House occupantsHouse = (House) personDao.searchHouse(eirCode);
        if(occupantsHouse  == null){
            return "The House you are Searching for doesn't exist, therefore there is no occupants \n";
        }
        List<Person> res = personDao.searchHousehold(eirCode);
        String occupants = "Occupants for House " + occupantsHouse.address + " with an eircode of " + occupantsHouse.eirCode ;
        for (int i = 0; i < res.size(); i++) {
            occupants = (occupants + " \nOccupant Number:" + (i + 1) + " " + res.get(i).personId + " " + res.get(i).personName + " " + res.get(i).age + "years old " + res.get(i).occupation + " " + res.get(i).eirCode + "\n");
        }

        return occupants;
    }


}





