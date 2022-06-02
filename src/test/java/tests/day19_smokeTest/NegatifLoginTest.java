package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegatifLoginTest {
    BrcPage brcPage = new BrcPage();

    @Test
    public void yanlisSifre() {
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //      login butonuna bas
        brcPage.ilkLoginButonu.click();

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        //login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();


    }
    @Test
    public void yanlisEmail() {
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //      login butonuna bas
        brcPage.ilkLoginButonu.click();


        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));


        brcPage.ikinciLoginButonu.click();


        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
        Driver.closeDriver();


    }
    @Test
    public void yanlisSifreEmail() {
        // Bir test method olustur positiveLoginTest()
        //       https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //      login butonuna bas
        brcPage.ilkLoginButonu.click();


        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcWrongEmail"));

        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));


        brcPage.ikinciLoginButonu.click();


        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());
Driver.closeDriver();


    }

}