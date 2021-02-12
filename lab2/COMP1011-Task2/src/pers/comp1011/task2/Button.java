/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-01-28
 * Purpose: Task2 - 2 Button Interface
 *
 *      Create Interface Button
 *      Give it two constants and two methods (be creative)
 */
package pers.comp1011.task2;

public interface Button {
    //Constants
    final String BUTTON_NAME = "Power button";
    final String BUTTON_FUNCTION = "Start computer/Shutdown computer";

    //Methods
    public void onClick();
    public void showFunction();
}
