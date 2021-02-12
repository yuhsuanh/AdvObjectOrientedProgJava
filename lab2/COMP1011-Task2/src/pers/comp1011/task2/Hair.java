/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-01-28
 * Purpose: Task2 - 5 Heart
 *
 *      Create a "interface"
 *      Interface can have:
 *         X instant variable
 *         V constant variable
 *         X constructor
 *         X concrete method
 *         V abstract method
 */
package pers.comp1011.task2;

public interface Hair {
    //constant variables
    final String STYLE = "Pompadour";
    final String TYPE = "Curly Hair";

    //abstract method
    //Interface methods are by default abstract and public
    public void cutHair();
    public abstract void tieHair();
}
