package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{

/*
###########################################################################
Method name : getDataObject
Method description : This method calls the getData method initiated on the actual csvfile,
path is taken from dataConfig xml.
Method parameters : N/A
Method return : Two dimensional array of Objects
###########################################################################
*/
    @DataProvider(name = "data-provider-users")
    public Object[][] getDataObject(){
        return getDataFromCSV(getData("DDTFile"));
    }

/*
###########################################################################
Method name : readCSV
Method description : This method reads the csv file and stores the data in a list.
Method parameters : String
Method return : List of Strings
###########################################################################
*/

    public static List<String> readCSV(String csvFile){
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

/*
###########################################################################
Method name : getDataFromCSV
Method description : This method returns the data from CSV file and stores it in a two dimensional array of objects
(using the split method).
Method parameters : String
Method return : Two dimensional array of Objects
###########################################################################
*/

    public static Object[][] getDataFromCSV(String filepath){
        Object[][] data = new Object[4][3];
        List <String> csvData = readCSV(filepath);
        for (int i = 0 ; i<csvData.size(); i++)
        {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
            data[i][2] = csvData.get(i).split(",")[2];

        }
        return data;
    }
}
