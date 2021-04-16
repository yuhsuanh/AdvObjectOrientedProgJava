package application;

import application.constants.AllConstant;
import application.services.DefaultDataService;
import application.services.FileService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class AutoWorldMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("views/auto_world.fxml");
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Selling Car App");
        stage.setScene(new Scene(root, 600, 510));
        stage.setResizable(false); //cannot change the scene size
        stage.show();
    }

    public static void main(String[] args) {
        //Check Is data files and image file are exists
        if(!FileService.checkDirectory(AllConstant.DATA_DIRECTORY_NAME) || !FileService.checkDirectory(AllConstant.IMG_DIRECTORY_NAME)) {
            DefaultDataService.createCompanyData();
            DefaultDataService.createCarsData();
        }

        launch(args);
    }
}
