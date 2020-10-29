package org.springProject.service;

import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    String deleteHero(int personId);
    String avg_age();
    String countOAP();
    String countStudents();
}
