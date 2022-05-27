package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {
    @Test

    public void test(){
        AmazonPage amazonPage=new AmazonPage();
        //amazona git
        Driver.getDriver().get("https://www.amazon.com");
        //nutella aratalim
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        //sonucun nutella icerdigini test edin
        String actualSonuc=amazonPage.aramaSonuc.getText();
        String arananKelime="Nutella";
        Assert.assertTrue(actualSonuc.contains(arananKelime));
        Driver.closeDriver();





    }
}
