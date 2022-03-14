package automation.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {

    static Properties prop = new Properties();


    public static void initProperties() {

        try {
            prop.load(new FileReader("src/test/resources/config/config.properties"));
        }
        catch (Exception e){
            System.out.println("\nException found on Properties: "+ e.toString());
        }
    }

    public static String getProperties(String key){
        return prop.getProperty(key);
    }


}
