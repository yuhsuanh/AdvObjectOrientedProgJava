/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-04-14
 */
package application.controllers;

import application.models.Company;
import application.services.FileService;
import application.services.GsonService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;


public class AutoWorldController {

    @FXML
    private ImageView imageViewLogo;

    @FXML
    private void initialize() {
        //get company information from file
        Company company = GsonService.readCompanyJsonFile();
        //set up image to imageview
        if(FileService.checkFileExist(company.getLogo())) {
            Image image = new Image(new File(company.getLogo()).toURI().toString());
            imageViewLogo.setImage(image);
        }

        //imageview click listener
        imageViewLogo.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent) {
                enterListPage(mouseEvent);
                ((Node) mouseEvent.getSource()).getScene().getWindow().hide();
            }
        });
    }

    @FXML
    private void enterListPage(MouseEvent mouseEvent) {
        try {
            //open a new window
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/list_page.fxml"));
            Parent listPageParent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Car List");
            stage.setScene(new Scene(listPageParent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
