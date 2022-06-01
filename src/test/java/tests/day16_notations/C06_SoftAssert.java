package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {
    /*
    Soft assertion baslangic ve bitis satirlari arasindaki
    tum asertionlari yapi bitis satirina geldiginde bize buldugu tum
     hatalari rapor eder.
     Soft Assert baslangici obje olusturmadir

     */
    SoftAssert softAssert=new SoftAssert();

    @Test(groups = "grup2")
    public void test01(){
        //amazona git
        driver.get("https://www.amazon.com");

        //tile nin amazon icerdigini test edin
        String expectedTitle="amazon";
        String actualTitle=driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");

        //arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erisilemiyor");

        // arama kutusuna nutella yazip aratin
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama yapildigini test edin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(),"arama yapilamadi");

        //arama sonucunun nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("kutella"),"arama kutella icermiyor");
        //soft ssert e bitis satirini soylemek icin assertAll() kullanilir
        // bu satir yazilmazsa assertion gorevi yapilmamis olur

        softAssert.assertAll();
        /*
        SoftAssert hata bulsa bile calismaya devam etme ozelligi assertAll e kadardir.
        eger assertAll da Faild rfapor edilirse calisma durur ve classin kalan kismi calistirilmaz
        AssertAll HardAsserteki herbir assert gibidir hatayi yakalarsa calisma durur.

         */



    }

}


