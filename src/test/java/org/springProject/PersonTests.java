package org.springProject;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springProject.classes.Person;
import org.springProject.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:beans.xml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PersonTests {
    @Autowired
    PersonDao personDao;


    @Test
    public void testSetPerson() {
        Person testPerson = new Person();

        testPerson.setPersonName("testName");
        testPerson.setOccupation("scholar");
        testPerson.setEirCode("testEirCode");
        testPerson.setAge(1);

        assertEquals("testName", testPerson.getPersonName());
        assertEquals("scholar", testPerson.getOccupation());
        assertEquals("testEirCode", testPerson.getEirCode());
        assertEquals(1, testPerson.getAge());
    }

    @Test
    public void testCountStudents(){
        int res = personDao.countStudents();
        assertEquals( 4, res);
    }

}
