/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-04-14
 */
package application.controllers;

import application.constants.AllConstant;
import application.models.Car;
import application.models.CarListItem;
import application.services.GsonService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.List;

public class ListPageController {
    private List<Car> carList;

    @FXML
    private CheckBox checkBoxAll;

    @FXML
    private CheckBox checkBoxSold;

    @FXML
    private CheckBox checkBoxAvailable;

    @FXML
    private TableView tableViewCarList;

    @FXML
    private void initialize() {
        carList = GsonService.readCarsJsonFile();

        //avoid click multiple check box
        setCheckBoxListener();

        //set up table view columns
        setTableViewColumns();

        //default display all cars
        checkBoxAll.setSelected(true);
        setTableViewItems(1);

        //set up double click row event
        tableViewCarList.setRowFactory(tv -> {
            TableRow<CarListItem> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    //get row data
                    CarListItem rowData = row.getItem();
                    System.out.println(rowData.getId());

                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/car_detail.fxml"));
                        Parent carParent = fxmlLoader.load();

                        Stage stage = new Stage();
                        stage.setTitle("Car Detail");
                        stage.setScene(new Scene(carParent));

                        //send carlistitem to next controller
                        CarDetailController carDetailController = fxmlLoader.getController();
                        carDetailController.initData(rowData);

                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            return row;
        });

    }

    @FXML
    private void enterAddCarPage(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/car_add.fxml"));
            Parent carParent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add a New Car");
            stage.setScene(new Scene(carParent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void enterCompanyInfo(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/company_info.fxml"));
            Parent companyParent = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Company Information");
            stage.setScene(new Scene(companyParent));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set up check box listener
     */
    private  void setCheckBoxListener() {
        //check box all
        checkBoxAll.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(t1) {
                    checkBoxSold.setSelected(false);
                    checkBoxAvailable.setSelected(false);
                }
            }
        });

        //check box sold
        checkBoxSold.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(t1) {
                    checkBoxAll.setSelected(false);
                    checkBoxAvailable.setSelected(false);
                }
            }
        });

        //check box available
        checkBoxAvailable.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(t1) {
                    checkBoxSold.setSelected(false);
                    checkBoxAll.setSelected(false);
                }
            }
        });
    }

    private double getResizeValue(double size) {
        return size / 200;
    }

    /**
     * set up columns and display name
     */
    private void setTableViewColumns() {
        //columns and display name
        TableColumn<CarListItem, String> idColumn = new TableColumn("id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<CarListItem, ImageView> imageColumn = new TableColumn("Image");
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        imageColumn.setMaxWidth(200);

        TableColumn<CarListItem, String> makeColumn = new TableColumn("Make");
        makeColumn.setCellValueFactory(new PropertyValueFactory<>("make"));

        TableColumn<CarListItem, String> modelColumn = new TableColumn("Model");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<CarListItem, String> doorColumn = new TableColumn("Doors");
        doorColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfDoor"));

        TableColumn<CarListItem, String> conditionColumn = new TableColumn("Condition");
        conditionColumn.setCellValueFactory(new PropertyValueFactory<>("condition"));

        TableColumn<CarListItem, String> engineColumn = new TableColumn("Engine");
        engineColumn.setCellValueFactory(new PropertyValueFactory<>("engine"));

        TableColumn<CarListItem, String> yearColumn = new TableColumn("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<CarListItem, String> priceColumn = new TableColumn("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<CarListItem, String> colorColumn = new TableColumn("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        TableColumn<CarListItem, String> soldColumn = new TableColumn("Sold Date");
        soldColumn.setCellValueFactory(new PropertyValueFactory<>("soldDate"));

        tableViewCarList.getColumns().add(idColumn);
        tableViewCarList.getColumns().add(imageColumn);
        tableViewCarList.getColumns().add(yearColumn);
        tableViewCarList.getColumns().add(makeColumn);
        tableViewCarList.getColumns().add(modelColumn);
        tableViewCarList.getColumns().add(colorColumn);
        tableViewCarList.getColumns().add(doorColumn);
        tableViewCarList.getColumns().add(conditionColumn);
        tableViewCarList.getColumns().add(engineColumn);
        tableViewCarList.getColumns().add(priceColumn);
        tableViewCarList.getColumns().add(soldColumn);
    }

    /**
     * clear items and set up the table items
     * option 1) all 2)available 3) sold
     * @param option
     */
    private void setTableViewItems(int option) {
        tableViewCarList.getItems().clear();

        for(Car car : carList) {
            if(option == 2 && car.getSoldDate() != null) // available
                continue;
            if(option == 3 && car.getSoldDate() == null) //sold
                continue;

            Image img = new Image(AllConstant.FILE_WITH_COLON + car.getImage());
            ImageView imageView = new ImageView(img);
            double d = getResizeValue(img.getWidth());
            imageView.setFitWidth(img.getWidth()/d);
            imageView.setFitHeight(img.getHeight()/d);

            CarListItem carListItem = new CarListItem(
                    car.getId(),
                    imageView,
                    car.getMake(),
                    car.getModel(),
                    car.getCondition(),
                    car.getEngine(),
                    car.getYear(),
                    car.getNumberOfDoor(),
                    car.getPrice(),
                    car.getColor(),
                    car.getSoldDate()
            );

            tableViewCarList.getItems().add(carListItem);
        }
    }

    @FXML
    private void searchCars(ActionEvent actionEvent) {
        carList = GsonService.readCarsJsonFile();

        if(checkBoxAll.isSelected()) {
            setTableViewItems(1);
        } else if (checkBoxAvailable.isSelected()) {
            setTableViewItems(2);
        } else if (checkBoxSold.isSelected()) {

            setTableViewItems(3);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("SELECT ERROR");
            alert.setContentText("You must select one search type");
            alert.show();
        }
    }
}
