package tests.day21_resuableMethods_HtmlReports;

import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ResMet;

import java.io.IOException;

public class C02_ScreenShotResuableMethod {
    @Test
    public void test() throws IOException {
        //amazona git fot. cek
        AmazonPage amazonPage=new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ResMet.getScreenshot("amazonHomePage");
        Driver.closeDriver();


    }

}
