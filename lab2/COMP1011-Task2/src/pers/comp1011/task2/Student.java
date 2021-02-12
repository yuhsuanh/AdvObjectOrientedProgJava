/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-01-28
 * Purpose: Task2 - 1 Student Class
 *
 *      Create a Student class
 *      it will store name and age
 *      The student name must at at least 5 characters
 *      The student age must be at least 18
 */
package pers.comp1011.task2;

public class Student {
    String name;
    int age;

    //Constructor
    public Student() {}

    public Student(String name, int age) throws Exception {
        setName(name);
        setAge(age);
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() < 5) {
            throw new Exception("The student name must be at least 5 characters!");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (age <18) {
            throw new Exception("The student age must be at least 18!");
        }
        this.age = age;
    }
}
