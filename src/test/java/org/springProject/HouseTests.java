package org.springProject;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springProject.classes.House;
import org.springProject.dao.HouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:beans.xml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class HouseTests {
    @Autowired
   HouseDao houseDao;



    @Order(1)
    @Test
    public void testSetHouse() {
        int res = houseDao.addHouse("testEirCode", "testAddress");
        assertEquals(1,res);

    }

    @Test
    @Order(2)
    public void searchHouse(){
        House test = houseDao.searchHouse("testEirCode");

        assertEquals("testAddress", test.getAddress());

    }
}




