package org.springProject;

import org.springProject.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonService personService = (PersonService) context.getBean("personServiceImplementation");


        System.out.println(personService.deleteHero(1));
        System.out.println(personService.deleteHero(1));

        System.out.println(personService.avg_age());
        System.out.println(personService.countOAP());


    }


}
