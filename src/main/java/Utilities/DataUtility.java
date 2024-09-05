package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {

    private static final String FilePath = "src/test/resources/TestData/" ;

    //TODO: Read Data From JSON File

    public static String getJSONData(String filename, String fieldname) throws FileNotFoundException {

        // src/test/resources/TestData/JsonData.json
        FileReader reader= new FileReader(FilePath + filename + ".json");
        JsonElement jsonElement= JsonParser.parseReader(reader);

        return jsonElement.getAsJsonObject().get(fieldname).getAsString();
    }
    //TODO: Read Data From Properties File

    public static String getPropertiesData (String filename, String fieldname) throws IOException {
        Properties properties = new Properties();
        //loading the properties file
        properties.load(new FileInputStream(FilePath + filename + ".properties"));
        return properties.getProperty(fieldname);

    }


}
