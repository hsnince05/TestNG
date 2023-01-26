package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproHomePage {

    public TechproHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='alert alert-success alert-dismissible fade show']")
    public WebElement anaSayfaText;

    @FindBy(xpath = "//*[@class='fa fa-sign-out-alt']")
    public WebElement logOut;


}
