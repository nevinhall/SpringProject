package org.springProject;


import org.springProject.classes.Person;
import org.springProject.service.ApplicationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationService applicationService = (ApplicationService) context.getBean("applicationServiceImplementation");


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
            System.out.println("7. Add a household, along with its occupant(s)");
            System.out.println("8. Add a new person and assign that person to a household");
            System.out.println("9. Delete a House with its occupants");


            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            System.out.println(userInput);

            switch (userInput) {
                case "1":

                    System.out.println("You Have Entered to Delete a Person");

                    System.out.println("Enter ID of Person to delete");
                    int personID = Integer.parseInt(sc.nextLine());

                    System.out.println(applicationService.deletePerson(personID));
                    runDefaults = 0;

                    break;
                case "2":

                    System.out.println("You Have Entered to View The Average Age of House Occupants");
                    System.out.println(applicationService.avg_age());
                    runDefaults = 0;

                    break;
                case "3":

                    System.out.println("You Have Entered to view the number of Old Age Pensioners in DB");
                    System.out.println(applicationService.countOAP());
                    runDefaults = 0;

                    break;
                case "4":

                    System.out.println("You Have Entered to view the Number of Students in DB");
                    System.out.println(applicationService.countStudents());
                    runDefaults = 0;

                    break;
                case "5":

                    System.out.println("You Have Entered to Search a Household and list given Occupants");

                    System.out.println("Enter Eircode of House you wish to see the occupants for");
                    String eirCode = sc.nextLine();

                    System.out.println(applicationService.searchHousehold(eirCode));
                    runDefaults = 0;

                    break;
                case "6":

                    System.out.println("You Have Entered to Move a person From one Household to another");
                    System.out.println("Enter New EirCode");
                    eirCode = sc.nextLine();

                    System.out.println("Enter PersonID");
                    personID = Integer.parseInt(sc.nextLine());

                    System.out.println(applicationService.moveHouse(personID, eirCode));
                    runDefaults = 0;

                    break;
                case "7":
                    System.out.println("You Have Entered to Add a household, along with its occupant(s)");

                    System.out.println("Enter House Address");
                    String address = sc.nextLine();

                    System.out.println("Enter House EirCode");
                    eirCode = sc.nextLine();


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
                    System.out.println(applicationService.addNewHouseWPeople(eirCode, address, people));


                    runDefaults = 0;

                    break;
                case "8":
                    System.out.println("You Have Entered to Add a new person and assign that person to a household ");
                    System.out.println("Enter Person Name:");
                    personName = sc.nextLine();

                    System.out.println("Enter Person Age:");
                    perosnAge = Integer.parseInt(sc.nextLine());

                    System.out.println("Enter Person Occupation:");
                    peronOccupation = sc.nextLine();

                    System.out.println("Enter House EirCode");
                    eirCode = sc.nextLine();



                    System.out.println(applicationService.addNewPersonToHouse(   personName, perosnAge, peronOccupation , eirCode));

                    runDefaults = 0;

                    break;
                case "9":
                    System.out.println("You Have Entered to Delete a House with its occupants ");
                    System.out.println("Enter eirCode of the house");
                    eirCode = sc.nextLine();


                    System.out.println(applicationService.removeHouseWOccupants(eirCode));


                    runDefaults = 0;

                    break;
            }


            if (userInput.equals("0")) {
                runApp = false;
                System.out.println("Application closing");
            }

            System.out.println("\n**************************************** \n");


        }


        System.out.println(applicationService.deletePerson(1));


        System.out.println(applicationService.deletePerson(1));
        System.out.println(applicationService.deletePerson(1));

        System.out.println(applicationService.avg_age());
        System.out.println(applicationService.countOAP());
        System.out.println(applicationService.countStudents());

        System.out.println(applicationService.searchHousehold("000"));

        System.out.println(applicationService.searchHousehold("0000"));

        System.out.println(applicationService.moveHouse(4, "p8k0"));


    }


}
