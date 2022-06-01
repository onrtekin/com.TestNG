package tests.day16_notations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C04_DependsOnMethods {
  /*
  DependsOn Methods test methodlarinin calisma siralamasina karismaz
  sadecebagli olan test baglandigi testin sonucuna bakar
  baglandigi test PASSED olmazsa baglanan test hic calismaz(ignore)
   */
  WebDriver driver;
  @BeforeClass
  public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

  }
  @AfterClass
  public void tearDown(){
    driver.close();
  }

  @Test(groups = {"grup1","grup2"})
  public void test01(){
      //amazona git
      driver.get("https://www.amazon.com");

  }
  @Test (dependsOnMethods="test01")
    public  void test02(){
      // nutella arat
      driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
  }


  @Test (dependsOnMethods="test02")
    public void test03(){
      //sonuc yazisinin nutella icerdigini testedin
      WebElement sonuc=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
      Assert.assertTrue(sonuc.getText().contains("Nutella"));

  }
}
