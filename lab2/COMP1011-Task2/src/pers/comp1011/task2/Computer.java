/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-01-28
 * Purpose: Task2 - 4 Computer class
 *
 *      Create concrete class named Computer
 *      This class is based on Keyboard class and implements Button
 *      Be creative
 */
package pers.comp1011.task2;

public class Computer extends Keyboard implements Button {

    boolean power;

    //Constructors
    public Computer() {};

    public Computer(boolean power) {
        this.power = power;
    }

    //Must write content to interface methods.
    @Override
    public void onClick() {
        power ^= power;
        if (power) {
            System.out.println("The computer power is ON");
        } else {
            System.out.println("The computer power is OFF");
        }
    }

    @Override
    public void showFunction() {
        System.out.println("This function is use to " + BUTTON_FUNCTION);
    }

    //Must write content to abstract method.
    @Override
    public String showKeyboardDescription() {
        //ternary operator
        String capsLockStatus = checkCapsLock()? "ON" : "OFF";
        return "The keyboard language is " + language + "\tCaps Lock is " + capsLockStatus;
    }
}
