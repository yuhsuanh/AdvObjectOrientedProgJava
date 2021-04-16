/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-04-15
 */
package application.controllers;

import application.models.Company;
import application.services.FileService;
import application.services.GsonService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class CompanyInfoController {
    private Company company;

    @FXML
    private Label labelName;

    @FXML
    private ImageView imageViewLogo;

    @FXML
    private Label labelNumSold;

    @FXML
    private Label labelProfit;

    @FXML
    private Label labelAddress;

    @FXML
    private Label labelCity;

    @FXML
    private Label labelProvince;

    @FXML
    private Label labelPostal;

    @FXML
    private Button buttonCancel;

    @FXML
    private void initialize() {
        company = GsonService.readCompanyJsonFile();

        //set up value to view
        labelNumSold.setText(company.getNumberOfCarSold().toString());
        labelProfit.setText(company.getTotalProfit().toString());
        labelName.setText(company.getName());
        labelAddress.setText(company.getAddress());
        labelCity.setText(company.getCity());
        labelProvince.setText(company.getProvince());
        labelPostal.setText(company.getPostalCode());
        if(FileService.checkFileExist(company.getLogo())) {
            Image image = new Image(new File(company.getLogo()).toURI().toString());
            imageViewLogo.setImage(image);
        }

    }

    @FXML
    private void enterEditCompanyPage() {
        try {
            //open a new window (edit company)
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/company_edit.fxml"));
            Parent companyEditParent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Edit Company Information");
            stage.setScene(new Scene(companyEditParent));
            stage.show();
            //close this window
            cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancel() {
        //close this window
        Stage stage = (Stage) buttonCancel.getScene().getWindow();
        stage.close();
    }
}
