package tests.day18_pom;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test() throws InterruptedException {

        FacebookPage facebookPage=new FacebookPage();
        //facebook anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // kullanici mail kutusuna rastgele bir isim yazdirin
       facebookPage.kullaniciMail.sendKeys(ConfigReader.getProperty("fbWrongUsername"));


        // kullanici sifre kutusuna rastgele bir password yazdirin
facebookPage.password.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        // login butonuna basin
facebookPage.login.click();


        // giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

        //sayfayi kapatin
        Driver.closeDriver();



    }
}

