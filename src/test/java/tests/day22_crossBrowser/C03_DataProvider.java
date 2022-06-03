package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @Test
    public void test01() {
        AmazonPage amazon = new AmazonPage();


        //amazona git
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //nutella arat
        amazon.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);


        //sonuclarin nutella icerdigini test edelim
       String expextedKelime="Nutella";
       String actualSonuc=amazon.aramaSonuc.getText();
       Assert.assertTrue(actualSonuc.contains(expextedKelime));
       Driver.closeDriver();

    }
    @DataProvider
    public static Object[][] AranacakKelimeler() {
      Object[][] arananKelimeArrayi= {{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};


        return arananKelimeArrayi;
    }
    @Test(dataProvider = "AranacakKelimeler")
    //arayacagimiz kelimeleri bir liste gibi tutup bana yollayacak bir veri saglayicisi olusturacagiz

    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage = new AmazonPage();
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella, Java,igdem,Netherlands icin arama yap
        amazonPage.aramaKutusu.sendKeys(arananKelime+ Keys.ENTER);

        //sonuclarin aradigimiz kelime icerdigini test edelim
        String expextedKelime=arananKelime;
        String actualSonuc=amazonPage.aramaSonuc.getText();
        Assert.assertTrue(actualSonuc.contains(expextedKelime));

        //sayfayi kapat
        Driver.closeDriver();

    }
}
