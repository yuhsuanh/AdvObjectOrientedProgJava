/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-03-01
 * Purpose: MVC architecture (Controller which uses to handles events)
 */
package assignment3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.util.HashMap;
import java.util.Map;

public class ScrabbleController {

    @FXML
    private TextField wordField;
    @FXML
    private TextField totalPoint;
    @FXML
    private TextArea previousWordArea;

    //Constant variable
    private final String LABEL_ID = "#num";
    private final String BUTTON_ID = "#button";
    //Instant variable
    private ScrabbleModel model;

    @FXML
    private void initialize() {
        System.out.println("Scrabble Game - START");
        //initial the model and total point
        model = new ScrabbleModel();
        totalPoint.setText("0");
    }

    @FXML
    private void onEnter(ActionEvent e) { //if TextField click Enter key
        submitWord(e);
    }

    @FXML
    private void submitWord(ActionEvent e) {
        int value = model.isWordValid(wordField.getText());

        //If the word is invalid, display error alert
        if(value == -1) {
            Alert duplicateError = new Alert(Alert.AlertType.ERROR);
            duplicateError.setTitle("Word Error");
            duplicateError.setContentText("The word is invalid!!!\nPlease try other words!");
            duplicateError.show();
        }
//        System.out.println("Submit: " + wordField.getText() + "\tValue: " + value);

        //update views
        updateInBagLabel(e);
        totalPoint.setText(String.valueOf(model.getTotalPoints()));
        previousWordArea.setText(model.getPreviousWords());
        wordField.setText("");

        //Statement of the game over
        if(model.getTotalNumberInBag() <= 1 || model.getTotalNumberVowel() == 0) {
            disableAllButton(e);

            Alert gameoverInfo = new Alert(Alert.AlertType.INFORMATION);
            gameoverInfo.setTitle("Game Over");
            gameoverInfo.setContentText("You total score is " + model.getTotalPoints());
            gameoverInfo.show();
        }
    }

    @FXML
    private void alphabetButtonHandler(ActionEvent e) {
        //all alphabet button will use this button handler
        //it will add the button text to the TextField
        Button alphabetButton = (Button)e.getSource();
        wordField.setText(wordField.getText() + alphabetButton.getText());
    }

    @FXML
    private void updateInBagLabel(ActionEvent e) {
        //get current scene
        Scene scene = ((Node) e.getTarget()).getScene();

        //Try to get the node (label/button) by id
        //System.out.println(scene.lookup("#numA"));
        //System.out.println(((Label)scene.lookup("#numA")).getText());
        //((Label)scene.lookup("#numA")).setText("123");
        //System.out.println(((Label)scene.lookup("#numA")).getText());

        //Set in bag label number & if the number is zero disable the button
        HashMap<Character, Alphabet> alphabets = model.getAlphabetHashMap();
        for (Map.Entry<Character, Alphabet> entry : alphabets.entrySet()) {
            ((Label) scene.lookup(LABEL_ID+entry.getKey())).setText(String.valueOf(entry.getValue().getInBag()));
            if(entry.getValue().getInBag() == 0) {
                ((Button) scene.lookup(BUTTON_ID+entry.getKey())).setDisable(true);
            }
        }
    }

    @FXML
    private void disableAllButton(ActionEvent e) {
        //get current scene
        Scene scene = ((Node) e.getTarget()).getScene();

        //disable submit button
        ((Button) scene.lookup("#submit")).setDisable(true);

        //disable alphabet buttons
        HashMap<Character, Alphabet> alphabets = model.getAlphabetHashMap();
        for (Map.Entry<Character, Alphabet> entry : alphabets.entrySet()) {
            ((Button) scene.lookup(BUTTON_ID+entry.getKey())).setDisable(true);
        }
    }
}
