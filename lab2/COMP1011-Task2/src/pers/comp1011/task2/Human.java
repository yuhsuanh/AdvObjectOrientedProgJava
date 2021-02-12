/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-01-28
 * Purpose: Task2 - 5 Human
 *
 *      Create a "concrete class"
 *      Concrete Class can have:
 *         V instant variable
 *         V constant variable
 *         V constructor
 *         V concrete method
 *         X abstract method
 */
package pers.comp1011.task2;

import java.util.Date;

public class Human {
    //instant variables
    String name;
    Date birthday;

    //constant variables
    final String SPECIES = "Human";
    final String NATIONALITY = "Canada";

    //constructors
    public Human() {}
    public Human(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    //concrete methods
    public void displayHumanInfo() {
        System.out.println(NATIONALITY + " " + name + "(" + SPECIES + ") " + birthday.toString());
    }
    public void displayAge() {
        Date today = new Date();
        int age = today.getYear() - birthday.getYear();
        System.out.println(age);
    }
}
