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
}
