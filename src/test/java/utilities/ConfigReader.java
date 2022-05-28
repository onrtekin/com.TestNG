package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        String dosyaYolu="target/configuration.properties";
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            //fis dosya yolunu tanimladigimiz configuration.properties dosyasini okudu
            properties=new Properties();

            properties.load(fis);
            //fisin okudugu bilgileri properties e yukledi


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        /*
        test methodundan yolladigimiz string key degerini alip Properties
         clasindan getProperty() methodunu kullanarak bu keye ait value getirir.

         */

        return properties.getProperty(key);

    }
}
