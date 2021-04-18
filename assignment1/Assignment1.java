/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-02-04
 * Purpose: Assignment 1 - I/O practice
 *
 */
package assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Assignment1 {

    public static void main(String[] args) {
        Scanner scanInt = new Scanner(System.in);
        int option = 0;

        do {
            //user can choose which task
            System.out.println("1)Task-1 2)Task-2 -1)Exit: ");
            option = scanInt.nextInt();

            switch (option) {
                case 1:
                    task1();
                    break;
                case 2:
                    task2();
                    break;
            }
        } while (option != -1);
    }

    //Task 1
    public static void task1() {
        Scanner scanStr = new Scanner(System.in);

        //ask the user for a file name
        System.out.println("Enter the file name: ");
        String fileName = scanStr.nextLine() + ".txt";

        try {
            FileWriter fileWriter = new FileWriter(fileName); //add second para true is to append the content to file
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //input file content until user input exit
            String content = "";
            do {
                System.out.println("Enter the text content(enter exit to exit): ");
                content = scanStr.nextLine();
                if(!content.equals("exit")) //don't write the text content, if user enters "exit"
                    bufferedWriter.write(content + "\n");
            } while (!content.equals("exit"));

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    //Task 2
    public static void task2() {
        Scanner scanStr = new Scanner(System.in);

        //ask the user for a relative path
        System.out.println("Enter a relative path: ");
        String relaPath = scanStr.nextLine();

        File directory =new File(relaPath);
        if(!directory.exists()){
            System.err.println("Relative Path Folder (" + relaPath + ") not exist!");
        } else {
            //save amount of directory & amount of file
            int directoryQty = 0, fileQty = 0;

            //use Stack (Last in, First out) / Queue (First in, First out) to iterate all directory (like maze question)
            Stack<File> stack = new Stack<File>();

            //push directory to stack
            stack.push(directory);
            while(!stack.isEmpty()) {
                for(File file: stack.pop().listFiles()) {
                    if(file.isDirectory()) {
                        //if it is sub-directory, pushing the directory to stack
                        stack.push(file);
                        directoryQty++;
                    } else if (file.isFile()) {
                        fileQty++;
                    }
                }
            }

            System.out.println("There are " + (directoryQty + fileQty) + " total files and directories; " + fileQty + " files & " + directoryQty + " directories.");
        }

    }
}
