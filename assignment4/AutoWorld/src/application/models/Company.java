/**
 * Author:
 * Date: 2021-04-14
 */
package application.models;

public class Company {

    private String name;
    private String logo;
    private String address;
    private String city;
    private String province;
    private String postalCode;
    private Integer numberOfCarSold;
    private Double totalProfit;

    //Constructors
    public Company() {}

    public Company(String name, String logo, String address, String city, String province, String postalCode, Integer numberOfCarSold, Double totalProfit) {
        this.name = name;
        this.logo = logo;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.numberOfCarSold = numberOfCarSold;
        this.totalProfit = totalProfit;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getNumberOfCarSold() {
        return numberOfCarSold;
    }

    public void setNumberOfCarSold(Integer numberOfCarSold) {
        this.numberOfCarSold = numberOfCarSold;
    }

    public Double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        this.totalProfit = totalProfit;
    }
}
