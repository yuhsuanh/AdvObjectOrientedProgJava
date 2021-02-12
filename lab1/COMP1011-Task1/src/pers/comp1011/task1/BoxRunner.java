/**
 * Author: Yu-Hsuan Huang
 * Date: 2020-01-21
 * Purpose: Task1 - 2 Practice
 *
 *      Create a Box class runner
 *      Ask the user how many Box objects to instantiate
 *      In loop
 *      Ask user for values of the six instance variables
 *      Pass the values to constructor (no error handling required for now)
 */
package pers.comp1011.task1;

import java.util.Scanner;

//Create a Box class runner
public class BoxRunner {
    public static void main(String[] args) {
        Scanner scanNum = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);

        //Ask the user how many Box objects to instantiate
        System.out.printf("How many box do you have?");
        int boxQty = scanNum.nextInt();

        //In loop
        //Ask user for values of the six instance variables
        //Pass the values to constructor (no error handling required for now)
        for(int i=0; i<boxQty; i++) {
            System.out.println("\nBox"+(i+1)+": ");

            System.out.printf("Input box is open(Ture/False): ");
            boolean boxOpen = scanNum.nextBoolean();

            System.out.printf("Input stuffs which inside box: ");
            String insideStuff = scanStr.nextLine();

            System.out.printf("Input box length: ");
            float length = scanNum.nextFloat();

            System.out.printf("Input box width: ");
            float width = scanNum.nextFloat();

            System.out.printf("Input box height: ");
            float height = scanNum.nextFloat();

            System.out.printf("Input box color: ");
            String color = scanStr.nextLine();

            Box box = new Box(boxOpen, insideStuff, length, width, height, color);
            System.out.println(box.toString());
        }
    }
}
