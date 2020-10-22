package org.springProject;

import org.springProject.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonService PersonService = (PersonService) context.getBean("PersonServiceImplementation");
    }


}
