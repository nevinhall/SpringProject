package org.springProject.service;

import org.springProject.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplementation implements PersonService {

    @Autowired
    PersonDao personDao;

    @Override
    public String deleteHero(int personId) {
        int res = personDao.deletePersonID(personId);
        return ("An attempt to delete the user with ID of : " + personId + " was executed with a result of: " +  res);
    }

    @Override
    public String avg_age() {
        int res = personDao.avg_age();
        return("The average age of a Person currently stored in the database is " + res + " years old");
    }

    @Override
    public String countOAP() {
        int res = personDao.countOAP();
        return("The number of Old Age Pensioners currently stored in the database is " + res);
    }

    @Override
    public String countStudents() {
        int res = personDao.countStudents();
        return ("The number of Students currently stored in the database is " + res);
    }


}
