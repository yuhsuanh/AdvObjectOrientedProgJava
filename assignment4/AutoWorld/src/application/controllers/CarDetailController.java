/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-04-15
 */
package application.controllers;

import application.models.CarListItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class CarDetailController {
    CarListItem carListItem;

    @FXML
    private ImageView imageViewCar;

    @FXML
    private Label labelMake;

    @FXML
    private Label labelModel;

    @FXML
    private Label labelCondition;

    @FXML
    private Label labelEngine;

    @FXML
    private Label labelYear;

    @FXML
    private Label labelDoor;

    @FXML
    private Label labelColor;

    @FXML
    private Label labelPrice;

    @FXML
    private Button buttonCancel;

    @FXML
    private Label labelDateSoldTitle;

    @FXML
    private Label labelDateSold;

    @FXML
    private void initialize() {
    }

    public void initData(CarListItem carListItem) {
        this.carListItem = carListItem;

        imageViewCar.setImage(carListItem.getImage().getImage());
        labelMake.setText(carListItem.getMake());
        labelModel.setText(carListItem.getModel());
        labelCondition.setText(carListItem.getCondition());
        labelEngine.setText(carListItem.getEngine());
        labelYear.setText(carListItem.getYear().toString());
        labelDoor.setText(carListItem.getNumberOfDoor().toString());
        labelColor.setText(carListItem.getColor());
        labelPrice.setText(carListItem.getPrice().toString());

        if(carListItem.getSoldDate() == null) {
            labelDateSoldTitle.setText("");
            labelDateSold.setText("");
        } else {
            labelDateSold.setText(carListItem.getSoldDate());
        }
    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void edit(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/car_edit.fxml"));
            Parent carParent = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Car Edit");
            stage.setScene(new Scene(carParent));

            CarEditController carEditController = fxmlLoader.getController();
            carEditController.initData(carListItem);

            stage.show();
            cancel(event);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
