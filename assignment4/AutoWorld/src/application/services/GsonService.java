/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-04-14
 */
package application.services;

import application.constants.AllConstant;
import application.models.Car;
import application.models.Company;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * You must to add gson to your library first
 */
public class GsonService {

    /**
     * Write company obj to company json file
     * @param company
     */
    public static void writeCompanyJsonFile(Company company) {
        Writer writer = null;

        //create data directory
        if(!FileService.checkDirectory(AllConstant.DATA_DIRECTORY_NAME)) {
            FileService.createDirectory(AllConstant.DATA_DIRECTORY_NAME);
        }

        //write json file
        try {
            writer = new FileWriter(AllConstant.COMPANY_FILE_PATH);
            new Gson().toJson(company, writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * read json file and parse to the Company obj
     * @return
     */
    public static Company readCompanyJsonFile() {
        Company company = null;
        Reader reader = null;

        try {
            reader = new FileReader(AllConstant.COMPANY_FILE_PATH);
            company = new Gson().fromJson(reader, Company.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return company;
    }

    /**
     * Write car list collection to json file
     * @param carList
     */
    public static void writeCarsJsonFile(List<Car> carList) {
        Writer writer = null;

        //create data directory
        if(!FileService.checkDirectory(AllConstant.DATA_DIRECTORY_NAME)) {
            FileService.createDirectory(AllConstant.DATA_DIRECTORY_NAME);
        }

        //write json file
        try {
            writer = new FileWriter(AllConstant.CARS_FILE_PATH);
            new Gson().toJson(carList, writer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * read car json file to
     * @return
     */
    public static List<Car> readCarsJsonFile() {
        List<Car> carList = null;
        Reader reader = null;

        try {
            reader = new FileReader(AllConstant.CARS_FILE_PATH);
            carList = new Gson().fromJson(reader, new TypeToken<ArrayList<Car>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return carList;
    }
}
