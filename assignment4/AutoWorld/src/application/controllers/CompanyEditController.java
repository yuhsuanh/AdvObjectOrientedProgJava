package application.controllers;

import application.models.Company;
import application.services.FileService;
import application.services.GsonService;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class CompanyEditController {

    private Company company;
    private File imageFile;

    @FXML
    private ImageView imageViewLogo;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextField textFieldAddress;

    @FXML
    private TextField textFieldCity;

    @FXML
    private TextField textFieldProvince;

    @FXML
    private TextField textFieldPostal;

    @FXML
    private Button buttonCancel;

    @FXML
    private void initialize() {
        imageFile = null;
        company = GsonService.readCompanyJsonFile();
        //set up values to text fields
        textFieldName.setText(company.getName());
        textFieldAddress.setText(company.getAddress());
        textFieldCity.setText(company.getCity());
        textFieldProvince.setText(company.getProvince());
        textFieldPostal.setText(company.getPostalCode());
        if(FileService.checkFileExist(company.getLogo())) {
            Image image = new Image(new File(company.getLogo()).toURI().toString());
            imageViewLogo.setImage(image);
        }

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
            imageViewLogo.setImage(image);
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
        if(imageFile != null) {
            FileService.saveImg(imageFile);
            company.setLogo(imageFile.getPath());
        }
        company.setName(textFieldName.getText());
        company.setAddress(textFieldAddress.getText());
        company.setCity(textFieldCity.getText());
        company.setProvince(textFieldProvince.getText());
        company.setPostalCode(textFieldPostal.getText());

        GsonService.writeCompanyJsonFile(company);
        //close this window
        cancel(event);
    }
}
