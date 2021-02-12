/**
 * Author: Yu-Hsuan Huang
 * Date: 2020-01-21
 * Purpose: Task1 - 1 Practice
 *
 *     Task 1
 *     Create a Box class with 6 instance variables
 *     2 each public, private, protected
 *     Create 3 constructors + the default constructor
 *     Create get and set methods for private and protected instance variables
 *     Give any restriction to the set methods ( has min length, has min value, etc)
 *     If restrictions met
 *     Set value
 *     If not
 *     output message
 */
package pers.comp1011.task1;

public class Box {

    //Variables
    //Create a Box class with 6 instance variables
    //2 each public, private, protected
    public boolean boxOpen;
    public String insideStuff;
    private float length;
    private float width;
    protected float height;
    protected String color;

    //Constructors
    //Create 3 constructors + the default constructor
    public Box() {}

    public Box(boolean boxOpen, String insideStuff) {
        this.boxOpen = boxOpen;
        this.insideStuff = insideStuff;
    }

    public Box(boolean boxOpen, String insideStuff, String color) {
        this.boxOpen = boxOpen;
        this.insideStuff = insideStuff;
        this.color = color;
    }

    public Box(boolean boxOpen, String insideStuff, float length, float width, float height, String color) {
        this.boxOpen = boxOpen;
        this.insideStuff = insideStuff;
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    //Getters and Setters
    //Create get and set methods for private and protected instance variables
    //Give any restriction to the set methods ( has min length, has min value, etc)
    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        if(length > 0 ) {
            this.length = length;
        } else {
            System.out.println("Length should greater than 0!");
        }
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        if(width > 0) {
            this.width = width;
        } else {
            System.out.println("Width should greater than 0!");
        }
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Height should greater than 0!");
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (!color.isEmpty()) {
            this.color = color;
        } else {
            this.color = "Brown";
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "open=" + boxOpen +
                ", insideStuff=" + insideStuff +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}
