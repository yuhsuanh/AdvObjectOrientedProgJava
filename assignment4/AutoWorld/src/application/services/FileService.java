/**
 * Author: Yu-Hsuan Huang
 * Date: 2021-04-14
 */
package application.services;

import application.constants.AllConstant;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * This class use to process files
 */
public class FileService {

    /**
     * check is the file exists
     * @param fileName
     * @return
     */
    public static boolean checkFileExist(String fileName) {
        File file =new File(fileName);
        if(file.exists() && !file.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check is the directory exists
     * @param directoryPath
     * @return
     */
    public static boolean checkDirectory(String directoryPath) {
        File directory =new File(directoryPath);
        if(directory.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * create the directory
     * @param directoryPath
     * @return
     */
    public static boolean createDirectory(String directoryPath) {
        if(!checkDirectory(directoryPath)) {
            new File(directoryPath).mkdirs();
            return true;
        }
        return false;
    }

    /**
     * use the file name to get file extension
     * @param file
     * @return
     */
    public static String getFileExtension(File file) {
        if(file != null) {
            int idx = file.getName().lastIndexOf(".");
            return file.getName().substring(idx+1);
        }
        return null;
    }

    /**
     * save image from your computer
     * @param file
     * @return
     */
    public static boolean saveImg(File file) {
        if(!checkDirectory(AllConstant.IMG_DIRECTORY_NAME)) {
            createDirectory(AllConstant.IMG_DIRECTORY_NAME);
        }

        if (file != null) {
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                ImageIO.write(bufferedImage, getFileExtension(file), new File(AllConstant.IMG_DIRECTORY_PATH + file.getName()));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * download image from url
     * @param img
     */
    public static void downloadImage(String img) {
        InputStream is = null;
        OutputStream os = null;

        try {
            URL url = new URL(AllConstant.IMG_URL + img);
            is = url.openStream();
            os = new FileOutputStream(img);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //close InputStream and OutputStream
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
