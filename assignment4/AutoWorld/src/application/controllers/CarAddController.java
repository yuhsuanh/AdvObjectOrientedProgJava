package application.controllers;

import application.models.Car;
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
import org.w3c.dom.Text;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarAddController {
    private File imageFile;

    @FXML
    private ImageView imageViewCar;

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
    private TextField textFieldColor;

    @FXML
    private TextField textFieldPrice;

    @FXML
    private Button buttonCancel;

    @FXML
    private void initialize() {
        setTextFieldNumericOnly();
    }

    /**
     * set up limited for text fields (number / decimal)
     */
    private void setTextFieldNumericOnly() {

        textFieldYear.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (!newValue.matches("\\d+")) {
                    textFieldYear.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

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
    private void cancel(ActionEvent event) {
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void save(ActionEvent event) {
        //if some fields null, show alert
        if( imageFile == null ||
            textFieldMake.getText().isEmpty() || textFieldModel.getText().isEmpty() ||
            textFieldCondition.getText().isEmpty() || textFieldEngine.getText().isEmpty() ||
            textFieldYear.getText().isEmpty() || textFieldDoor.getText().isEmpty() ||
            textFieldPrice.getText().isEmpty() || textFieldColor.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Field Empty Error");
            alert.setContentText("You have to fill all fields!");
            alert.show();
            return;
        }

        //get car list
        List<Car> carList = GsonService.readCarsJsonFile();
        Car car = new Car();

        //save image file to your computer
        if(imageFile != null) {
            FileService.saveImg(imageFile);
            car.setImage(imageFile.getPath());
        }

        car.setMake(textFieldMake.getText());
        car.setModel(textFieldModel.getText());
        car.setCondition(textFieldCondition.getText());
        car.setEngine(textFieldEngine.getText());
        car.setYear(Integer.parseInt(textFieldYear.getText()));
        car.setNumberOfDoor(Integer.parseInt(textFieldDoor.getText()));
        car.setPrice(Double.parseDouble(textFieldPrice.getText()));
        car.setColor(textFieldColor.getText());
        car.setId(carList.size()+1);

        //add new car to list
        carList.add(car);
        //write file
        GsonService.writeCarsJsonFile(carList);
        //close this window
        cancel(event);
    }
}
