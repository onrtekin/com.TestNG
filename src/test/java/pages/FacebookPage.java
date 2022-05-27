package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath="//input[@type='text']")
    public WebElement kullaniciMail;
    @FindBy(xpath="//input[@type='password']")
    public WebElement password;
    @FindBy(xpath="//button[@name='login']")
    public WebElement login;
    @FindBy(xpath="//div[@class='_9ay7']")
    public WebElement girilemediYaziElementi;



}
