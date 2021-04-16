/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-04-15
 */
package application.services;

import application.constants.AllConstant;
import application.models.Car;
import application.models.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * This class use to create default data and download images from my github to your computer
 */
public class DefaultDataService {

    /**
     * create company json data file i your computer
     */
    public static void createCompanyData() {
        //create data directory if not exists
        if(!FileService.checkDirectory(AllConstant.DATA_DIRECTORY_NAME))
            FileService.createDirectory(AllConstant.DATA_DIRECTORY_NAME);
        //create img directory if not exists
        if(!FileService.checkDirectory(AllConstant.IMG_DIRECTORY_PATH))
            FileService.createDirectory(AllConstant.IMG_DIRECTORY_PATH);

        //Download image
        FileService.downloadImage(AllConstant.COMPANY_IMG);

        //Create default company object
        Company company = new Company(
                AllConstant.COMPANY_NAME,
                AllConstant.COMPANY_IMG,
                AllConstant.ADDRESS,
                AllConstant.CITY,
                AllConstant.PROVINCE,
                AllConstant.POSTAL_CODE,
                AllConstant.SOLD_NUMBER,
                AllConstant.TOTAL_PROFIT
        );

        //write company json file to data directory
        GsonService.writeCompanyJsonFile(company);
    }

    /**
     * create cars json data file i your computer
     */
    public static void createCarsData() {
        //create data directory if not exist
        if(!FileService.checkDirectory(AllConstant.DATA_DIRECTORY_NAME))
            FileService.createDirectory(AllConstant.DATA_DIRECTORY_NAME);
        //create img directory if not exists
        if(!FileService.checkDirectory(AllConstant.IMG_DIRECTORY_NAME))
            FileService.createDirectory(AllConstant.IMG_DIRECTORY_NAME);

        //create Default car list collection
        List<Car> carList = new ArrayList<Car>();
        for (int i = 0; i < AllConstant.CAR_MAKES.length; i++) {
            //download the image
            FileService.downloadImage(AllConstant.CAR_IMG[i]);
            //create car object and add to car list
            Car car = new Car();
            car.setId(AllConstant.CAR_ID[i]);
            car.setMake(AllConstant.CAR_MAKES[i]);
            car.setModel(AllConstant.CAR_MODEL[i]);
            car.setCondition(AllConstant.CAR_CONDITION[i]);
            car.setEngine(AllConstant.CAR_ENGINE[i]);
            car.setYear(AllConstant.CAR_YEAR[i]);
            car.setNumberOfDoor(AllConstant.CAR_NUMBER_OF_DOOR[i]);
            car.setPrice(AllConstant.CAR_PRICE[i]);
            car.setColor(AllConstant.CAR_COLOR[i]);
            car.setImage(AllConstant.CAR_IMG[i]);
            if (!AllConstant.CAR_SOLD_DATE[i].isEmpty())
                car.setSoldDate(AllConstant.CAR_SOLD_DATE[i]);
            carList.add(car);
        }

        //write car json file to data directory
        GsonService.writeCarsJsonFile(carList);
    }

}
