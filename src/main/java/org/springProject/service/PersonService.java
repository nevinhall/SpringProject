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
    String moveHouse(int personId, String newEirCode);
    String addNewPersonToHouse(String personName,int age,String occupation,String eirCode);
}
