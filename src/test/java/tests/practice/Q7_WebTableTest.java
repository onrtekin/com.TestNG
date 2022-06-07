package tests.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebTablePage;
import utilities.Driver;
import utilities.TestBase;
import utilities.TestBaseRapor;

public class Q7_WebTableTest extends TestBaseRapor {

    /*
go to url : https://en.wikipedia.org/wiki/Dell
go to table which name is 'List of companies acquired by Dell Inc.'
print row 4 of the table on console
also print on console the 2nd and 3rd elements (middle 2 elements) in line 5
( 2nd and 3rd elements : November 2, Cloud integration leader)
  Verify that Compellent appears in the first cell of line 6

url'ye gidin: https://en.wikipedia.org/wiki/Dell
 'List of companies acquired by Dell Inc.' isimli tabloya gidin,
 tablonun 4. satırını konsolda yazdırın
 ayrıca 5. satırdaki 2. ve 3. öğeleri (ortadaki 2 öğe) konsola yazdırın
 ( 2nd and 3rd ogeler : November 2, Cloud integration leader)
 6. satirin ilk hucresinde Compellent yazisinin goruntulendigini dogrulayin

 */
    WebTablePage webtablePage=new WebTablePage();
    @Test
    public void test(){
        extentTest=extentReports.createTest("webtable test","table test");
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get("https://en.wikipedia.org/wiki/Dell");
        extentTest.info("istenilen url e gidildi");

        jse.executeScript("arguments[0].scrollIntoView(true);",webtablePage.dortSatir);

        System.out.println("4.satir : "+ webtablePage.dortSatir.getText());
        extentTest.info("4. satir consolda yazildi");

        System.out.println("ikinci oge : "+webtablePage.ikinciOge.getText());
        extentTest.info("2. oge  consolda yazildi");

        System.out.println("ucuncu oge : "+webtablePage.ucuncuOge.getText());
        extentTest.info("3. oge consolda yazildi");

        Assert.assertTrue(webtablePage.altinciElement.isDisplayed());

        extentTest.pass("Compellent yazi goruldu");




    }

}
