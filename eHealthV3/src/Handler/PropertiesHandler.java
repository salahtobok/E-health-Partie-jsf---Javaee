package Handler;

import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

    public static String getProperty(Class currentClass, String propertyName, String key) {
        try {
            Properties defaultProperties = new Properties();

            defaultProperties.load(currentClass.getClassLoader().getResourceAsStream(propertyName));

            return defaultProperties.getProperty(key);
        } catch (IOException e) {
            System.out.println("Lol --> " + e.getMessage());
            return null;
        }

    }
}
