package tests.day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
    Test NG test methodlarini isim sirasina gore calistirir
    isim siralamasinin disanda calismasini isterseniz o zaman test
     methodlarina oncelik (priority)
    tanimlayabiliriz
    Priority kucukten buyuge calisir eger bir test methoduna Priority degeri
    atanmamissa default olarak Pri:0 kabul edilir
     */

    @Test (priority =-5)

    public void amazontest(){
        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());
        driver.close();

    }
    @Test (priority =-2)
    public void test02(){
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
    @Test
    public void techproedTesti(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }
}
