package org.springProject.service;

import org.springProject.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImplementation implements PersonService {

    @Autowired
    PersonDao personDao;
}
