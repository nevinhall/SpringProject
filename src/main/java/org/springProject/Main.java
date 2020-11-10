package org.springProject;


import org.springProject.classes.Person;
import org.springProject.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        PersonService personService = (PersonService) context.getBean("personServiceImplementation");

        Boolean runApp = true;
        int runDefaults = 1;
        while (runApp) {

            if (runDefaults == 1) {
                System.out.println("A run defaults \n");
            }
            System.out.println("Enter Choice:");
            System.out.println("1. Delete a Person");
            System.out.println("2. Average Age of House Occupants");
            System.out.println("3. Number of Old Age Pensioners in DB");
            System.out.println("4. Number of Students in DB");
            System.out.println("5. Search Household and list given Occupants");
            System.out.println("6. Move person From one Household to another");
            System.out.println("6. Move person From one Household to another");
            System.out.println("7. Add a household, along with its occupant(s)");
            System.out.println("8. Add a new person and assign that person to a household");


            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            System.out.println(userInput);

            switch (userInput) {
                case "1":

                    System.out.println("You Have Entered to Delete a Person");
                    System.out.println(personService.deleteHero(1));
                    runDefaults = 0;

                    break;
                case "2":

                    System.out.println("You Have Entered to View The Average Age of House Occupants");
                    System.out.println(personService.avg_age());
                    runDefaults = 0;

                    break;
                case "3":

                    System.out.println("You Have Entered to view the number of Old Age Pensioners in DB");
                    runDefaults = 0;

                    break;
                case "4":

                    System.out.println("You Have Entered to view the Number of Students in DB");
                    System.out.println(personService.countStudents());
                    runDefaults = 0;

                    break;
                case "5":

                    System.out.println("You Have Entered to Search a Household and list given Occupants");
                    System.out.println(personService.searchHousehold("000"));
                    runDefaults = 0;

                    break;
                case "6":

                    System.out.println("You Have Entered to Move a person From one Household to another");
                    System.out.println(personService.moveHouse(4, "p8k0"));
                    runDefaults = 0;

                    break;
                case "7":
                    System.out.println("You Have Entered to Add a household, along with its occupant(s)");

                    System.out.println("Enter House Address");
                    String address = sc.nextLine();

                    System.out.println("Enter House EirCode");
                    String eirCode = sc.nextLine();


                    System.out.println("How Many occupants are moving into this house?");
                    int numOccupants = Integer.parseInt(sc.nextLine());

                    ArrayList<Person> people = new ArrayList<Person>();

                    int i = 0;

                    String personName;
                    int perosnAge;
                    String peronOccupation;

                    while (i < numOccupants) {
                        System.out.println("Enter Person Name:");
                        personName = sc.nextLine();

                        System.out.println("Enter Person Age:");
                        perosnAge = Integer.parseInt(sc.nextLine());

                        System.out.println("Enter Person Occupation:");
                        peronOccupation = sc.nextLine();

                        Person p = new Person();
                        p.setPersonName(personName);
                        p.setOccupation(peronOccupation);
                        p.setEirCode(eirCode);
                        p.setAge(perosnAge);

                        people.add(p);


                        i++;
                    }
                    System.out.println(personService.addNewHouseWPeople(eirCode, address, people));


                    runDefaults = 0;

                    break;
                case "8":
                    System.out.println("You Have Entered to Add a new person and assign that person to a household ");
                    System.out.println(personService.addNewPersonToHouse("testName", 99, "scholar", "0000"));

                    runDefaults = 0;

                    break;
            }


            if (userInput.equals("0")) {
                runApp = false;
                System.out.println("Application closing");
            }

            System.out.println("\n**************************************** \n");


        }


        System.out.println(personService.deleteHero(1));


        System.out.println(personService.deleteHero(1));
        System.out.println(personService.deleteHero(1));

        System.out.println(personService.avg_age());
        System.out.println(personService.countOAP());
        System.out.println(personService.countStudents());

        System.out.println(personService.searchHousehold("000"));

        System.out.println(personService.searchHousehold("0000"));

        System.out.println(personService.moveHouse(4, "p8k0"));


    }


}
