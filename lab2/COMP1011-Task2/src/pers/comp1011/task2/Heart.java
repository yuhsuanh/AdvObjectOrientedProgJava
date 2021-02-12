/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-01-28
 * Purpose: Task2 - 5 Heart
 *
 *      Create a "abstract class"
 *      Abstract class can have:
 *         V instant variable
 *         V constant variable
 *         V constructor
 *         V concrete method
 *         V abstract method
 */
package pers.comp1011.task2;

public abstract class Heart {
    //instant variables
    int heartbeat; //bpm
    String[] diseases;

    //constant variables
    final String[] CHAMBERS = {"right atrium", "right ventricle", "right ventricle", "left ventricle"};
    final String[] FUNCTIONS = {
            "Pumping oxygenated blood to the other body parts",
            "Pumping hormones and other vital substances to different parts of the body",
            "Receiving deoxygenated blood and carrying metabolic waste products from the body and pumping it to the lungs for oxygenation",
            "Maintaining blood pressure"};

    //constructors
    public Heart() {}
    public Heart(int heartbeat) {
        this.heartbeat = heartbeat;
    }
    public Heart(String[] diseases) {
        this.diseases = diseases;
    }
    public Heart(int heartbeat, String[] diseases) {
        this.heartbeat = heartbeat;
        this.diseases = diseases;
    }

    //abstract method
    public abstract void addDisease(String disease);
    public abstract void measureHeartbeat();

    //concrete method
    public void displayHeartChambers() {
        for(int i = 0; i < CHAMBERS.length; i++){
            System.out.println(CHAMBERS[i]);
        }
    }
    public void displayHeartFunctions() {
        for(int i = 0; i < FUNCTIONS.length; i++){
            System.out.println(FUNCTIONS[i]);
        }
    }
}
