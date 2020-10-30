package org.springProject.service;

import org.springProject.classes.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {
    String deleteHero(int personId);
    String avg_age();
    String countOAP();
    String countStudents();
    String searchHousehold(String eirCode);
}
