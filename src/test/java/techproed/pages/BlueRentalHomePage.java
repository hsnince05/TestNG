package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalHomePage {

    public BlueRentalHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Login")
    public WebElement loginLink;

    @FindBy(id="dropdown-basic-button")
    public WebElement userID;

    @FindBy(linkText ="Logout")
    public WebElement logOutLink;

    @FindBy(xpath = "//button[.='OK']")
    public WebElement OK;

    @FindBy(xpath = "//*[@name='car']")
    public WebElement select_car;

    @FindBy(xpath = "//input[@title='Pick Up']")
    public WebElement pickUp_konum;

    @FindBy(xpath = "//input[@title='Drop Off']")
    public WebElement dropOff_konum;

    @FindBy(xpath = "//input[@name='pickUpDate']")
    public WebElement pickUp_date;

    @FindBy(xpath = "//input[@name='pickUpTime']")
    public WebElement pickUp_time;

    @FindBy(xpath = "//input[@name='dropOffDate']")
    public WebElement dropOff_tarih;

    @FindBy(xpath = "//input[@name='dropOffTime']")
    public WebElement dropOff_time;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continue_reservation;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement error_message;
}
