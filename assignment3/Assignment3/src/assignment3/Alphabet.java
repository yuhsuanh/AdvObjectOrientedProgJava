/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-03-01
 * Purpose: Alphabet class used to save the point and number of in bag for each alphabet
 */
package assignment3;

public class Alphabet {
    //Instant variables
    private char alphabet;
    private int point;
    private int inBag;

    //Instructors
    public Alphabet() {}
    public Alphabet(char alphabet, int point, int inBag) {
        this.alphabet = alphabet;
        this.point = point;
        this.inBag = inBag;
    }

    //Getters and Setters
    public char getAlphabet() {
        return alphabet;
    }
    public void setAlphabet(char alphabet) {
        this.alphabet = alphabet;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public int getInBag() {
        return inBag;
    }
    public void setInBag(int inBag) {
        this.inBag = inBag;
    }
}
