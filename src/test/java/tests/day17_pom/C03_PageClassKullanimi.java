package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C03_PageClassKullanimi {
    @Test
    public void test() {
        FacebookPage facebookPage=new FacebookPage();
        //facebook  a git
        Driver.getDriver().get("https://www.facebook.com");

        //kullanici mail kutusuna rastgele isim yazdirin
        Faker faker=new Faker();

        facebookPage.kullaniciMail.sendKeys(faker.internet().emailAddress());

        //kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.password.sendKeys(faker.internet().password());

        //login butonuna basin
        facebookPage.login.click();

        //giris yapilmadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        Driver.closeDriver();



    }
}
