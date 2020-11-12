package org.springProject;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springProject.classes.House;
import org.springProject.classes.Person;
import org.springProject.dao.HouseDao;
import org.springProject.dao.HouseDaoImplementation;
import org.springProject.dao.PersonDao;
import org.springProject.dao.PersonDaoImplementation;
import org.springProject.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:beans.xml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class HouseTests {
    @Autowired
   HouseDao houseDao;

    House testHouse = new House();


    @Test
    public void testSetHouse() {


        testHouse.setAddress("testAddress");
        testHouse.setEirCode("testEirCode");

        assertEquals("testAddress",testHouse.getAddress());
        assertEquals("testEirCode",testHouse.getEirCode());
    }

    @Test
    public void searchHouse(){
        HouseDao houseDao = new HouseDaoImplementation();
        House test = houseDao.searchHouse(testHouse.getEirCode());

        assertEquals("testAddress", test.getAddress());

    }
}




