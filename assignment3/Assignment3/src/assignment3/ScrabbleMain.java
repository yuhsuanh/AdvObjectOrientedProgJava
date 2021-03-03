/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-03-01
 * Purpose: JavaFX Project - Scrabble game
 */
package assignment3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScrabbleMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scrabble.fxml"));
        primaryStage.setTitle("Scrabble Game");
        primaryStage.setScene(new Scene(root, 601, 507));
        primaryStage.setResizable(false); //cannot change the scene size
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
