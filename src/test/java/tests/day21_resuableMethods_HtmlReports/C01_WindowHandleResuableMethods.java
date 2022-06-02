package tests.day21_resuableMethods_HtmlReports;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ResMet;

import java.util.Set;

public class C01_WindowHandleResuableMethods {
    @Test
    public void test(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandle=Driver.getDriver().getWindowHandle();

        // Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        Set<String> windowHandleSeti=Driver.getDriver().getWindowHandles();
        String ikinciSayfaWindowHandle="";
        for (String each:windowHandleSeti) {
            if(!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=each;

            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWindowHandle);

        System.out.println(Driver.getDriver().getTitle());

        // acilan yeni tabin "New Window" oldugunu test edin

        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);


    }
    @Test
    public void test2(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        // Click Here butonuna basin
        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        // acilan yeni tabin "New Window" oldugunu test edin
        ResMet.switchToWindow("New Window");
        String expectedTitle="New Window";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        Driver.getDriver().quit();



    }
}
