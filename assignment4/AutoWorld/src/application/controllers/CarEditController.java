/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-04-16
 */
package application.controllers;

import application.models.Car;
import application.models.CarListItem;
import application.models.Company;
import application.services.FileService;
import application.services.GsonService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarEditController {
    private CarListItem carListItem;
    private File imageFile;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonSave;

    @FXML
    private ImageView imageViewCar;

    @FXML
    private Button buttonUploadImg;

    @FXML
    private TextField textFieldMake;

    @FXML
    private TextField textFieldModel;

    @FXML
    private TextField textFieldCondition;

    @FXML
    private TextField textFieldEngine;

    @FXML
    private TextField textFieldYear;

    @FXML
    private TextField textFieldDoor;

    @FXML
    private TextField textFieldPrice;

    @FXML
    private TextField textFieldColor;

    @FXML
    private TextField textFieldSoldDate;


    @FXML
    private void initialize() {
        imageFile = null;
        setTextFieldNumericOnly();
    }

    public void initData(CarListItem carListItem) {
        this.carListItem = carListItem;

        imageViewCar.setImage(carListItem.getImage().getImage());
        textFieldMake.setText(carListItem.getMake());
        textFieldModel.setText(carListItem.getModel());
        textFieldCondition.setText(carListItem.getCondition());
        textFieldEngine.setText(carListItem.getEngine());
        textFieldYear.setText(carListItem.getYear().toString());
        textFieldDoor.setText(carListItem.getNumberOfDoor().toString());
        textFieldColor.setText(carListItem.getColor());
        textFieldPrice.setText(carListItem.getPrice().toString());
        textFieldSoldDate.setText(carListItem.getSoldDate());
    }

    private void setTextFieldNumericOnly() {
        //only number
        textFieldYear.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\d+")) {
                    textFieldYear.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        //only number
        textFieldDoor.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\d+")) {
                    textFieldDoor.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        //decimal
        textFieldPrice.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    textFieldPrice.setText(oldValue);
                }
            }
        });

    }

    @FXML
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void uploadImageActionPerformed(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        //type of file
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        //set types
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);
        //set title
        fileChooser.setTitle("Choose Image File");

        //display dialog
        imageFile = fileChooser.showOpenDialog(null);

        //save image under imgs directory
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(imageFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageViewCar.setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void save(ActionEvent event) {
        //get company and car from files
        Company company = GsonService.readCompanyJsonFile();
        List<Car> carList = GsonService.readCarsJsonFile();

        //get car from car list collection and get index
        Car car = carList.stream().filter(c -> c.getId() == carListItem.getId()).findFirst().orElse(null);
        int index = carList.indexOf(car);

        //check all fields are not null except sold date
        if( imageViewCar.getImage() == null ||
            textFieldMake.getText().isEmpty() || textFieldModel.getText().isEmpty() ||
            textFieldCondition.getText().isEmpty() || textFieldEngine.getText().isEmpty() ||
            textFieldYear.getText().isEmpty() || textFieldDoor.getText().isEmpty() ||
            textFieldPrice.getText().isEmpty() || textFieldColor.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Field Empty Error");
            alert.setContentText("You have to fill all fields except sold date!");
            alert.show();
            return;
        } else if (car == null) { //it should not been happen (not find car obj)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ID Error");
            alert.setContentText("Something Error! please close the windows and try it again!");
            alert.show();
            return;
        }


        if(imageFile != null) {
            FileService.saveImg(imageFile);
            car.setImage(imageFile.getPath());
        }
        if(textFieldSoldDate != null) {
            car.setSoldDate(textFieldSoldDate.getText());
        }

        car.setMake(textFieldMake.getText());
        car.setModel(textFieldModel.getText());
        car.setCondition(textFieldCondition.getText());
        car.setEngine(textFieldEngine.getText());
        car.setYear(Integer.parseInt(textFieldYear.getText()));
        car.setNumberOfDoor(Integer.parseInt(textFieldDoor.getText()));
        car.setPrice(Double.parseDouble(textFieldPrice.getText()));
        car.setColor(textFieldColor.getText());

        carList.set(index, car);

        //set number of sold cars and total profit for compnay
        int soldNum = 0;
        double totalProfit = 0;
        for(Car c : carList) {
            if(c.getSoldDate() != null) {
                soldNum ++;
                totalProfit += c.getPrice();
            }
        }
        company.setNumberOfCarSold(soldNum);
        company.setTotalProfit(totalProfit);

        //write cars and company files
        GsonService.writeCarsJsonFile(carList);
        GsonService.writeCompanyJsonFile(company);
        //close this window
        cancel(event);
    }
}
