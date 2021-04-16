package application.models;


import javafx.scene.image.ImageView;

public class CarListItem {
    private Integer id;
    private ImageView image;
    private String make;
    private String model;
    private String condition;
    private String engine;
    private Integer year;
    private Integer numberOfDoor;
    private Double price;
    private String color;
    private String soldDate;

    //Constructors
    public CarListItem() {}

    public CarListItem(Integer id, ImageView image, String make, String model, String condition, String engine, Integer year, Integer numberOfDoor, Double price, String color, String soldDate) {
        this.id = id;
        this.image = image;
        this.make = make;
        this.model = model;
        this.condition = condition;
        this.engine = engine;
        this.year = year;
        this.numberOfDoor = numberOfDoor;
        this.price = price;
        this.color = color;
        this.soldDate = soldDate;
    }

    //Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNumberOfDoor() {
        return numberOfDoor;
    }

    public void setNumberOfDoor(Integer numberOfDoor) {
        this.numberOfDoor = numberOfDoor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }
}
