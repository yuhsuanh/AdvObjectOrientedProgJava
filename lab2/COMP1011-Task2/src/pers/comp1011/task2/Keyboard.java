/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-01-28
 * Purpose: Task2 - 3 Keyboard abstract class
 *
 *      Create abstract class Keyboard
 *      Give the abstract class two instance variables, concrete methods, abstract methods and constructors
 *      Be creative
 */
package pers.comp1011.task2;

public abstract class Keyboard {

    //instance variables
    String language;
    boolean capsLock;

    //Constructors
    public Keyboard() {}

    public Keyboard(String language, boolean capsLock) {
        this.language = language;
        this.capsLock = capsLock;
    }

    //Concrete methods
    public boolean checkCapsLock() {
        return capsLock;
    }

    public String checkLanguage() {
        return language;
    }

    //Abstract method
    public abstract String showKeyboardDescription();

}
