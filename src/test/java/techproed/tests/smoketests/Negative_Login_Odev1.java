package techproed.tests.smoketests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Negative_Login_Odev1 {

    /*
         Name:
        US100402_Negative_Login
        Description:
        Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
        Acceptance Criteria:
        Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
        Hata Mesaji:
        Bad credentials
        Test Data:
        Customer email: jack@gmail.com
        Customer password: fakepass
     */

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;

    Faker faker;

//    @Test
//    public void email_uzantisi(String emails) {
//        Driver.getDriver().get("https://email-verify.my-addr.com/list-of-most-popular-email-domains.php");
//        List<WebElement> emailuzantilari = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//table[@style='text-align:left;']//tbody//tr")));
//        emailuzantilari.stream().forEach(t -> System.out.println(t.getText()));
//
//    }


    @Test
    public void us100402_Negative_Login() throws InterruptedException {

        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(ConfigReader.getProperty("admin_email"));
        blueRentalLoginPage.passwordBox.sendKeys(ConfigReader.getProperty("fake_pass"));
        blueRentalLoginPage.loginButton.click();

        Thread.sleep(2000);
        Assert.assertEquals(blueRentalLoginPage.error_message_1.getText(),"Bad credentials");
        Thread.sleep(2000);

        Driver.closeDriver();
    }

    @Test
    public void us101122_Negative_Login() throws InterruptedException {
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();
        faker=new Faker();

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        blueRentalHomePage.loginLink.click();
        blueRentalLoginPage.emailBox.sendKeys(faker.name().firstName());
        blueRentalLoginPage.passwordBox.sendKeys("admin_sifre");
        blueRentalLoginPage.loginButton.click();
        Assert.assertTrue(blueRentalLoginPage.email_hata_message.isDisplayed());

        Thread.sleep(2000);

        blueRentalLoginPage.emailBox.sendKeys(faker.internet().emailAddress());
        Thread.sleep(2000);
        Assert.assertFalse(blueRentalLoginPage.email_hata_message.isDisplayed());

        Thread.sleep(2000);
        Driver.closeDriver();

    }

    @Test
    public void us101201_Negative_Login() throws InterruptedException {
        blueRentalHomePage = new BlueRentalHomePage();
        faker= new Faker();

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        Select select = new Select(blueRentalHomePage.select_car);
        select.selectByVisibleText("Mercedes Vito");
        blueRentalHomePage.pickUp_konum.sendKeys(faker.address().cityName());
        blueRentalHomePage.dropOff_konum.sendKeys(faker.address().cityName());
        blueRentalHomePage.pickUp_date.sendKeys("28/01/2023");
        blueRentalHomePage.pickUp_time.sendKeys("12.00");
        blueRentalHomePage.dropOff_tarih.sendKeys("02/02/2023");
        blueRentalHomePage.dropOff_time.sendKeys("15.00");
        blueRentalHomePage.continue_reservation.click();
        Thread.sleep(2000);

        Assert.assertEquals(blueRentalHomePage.error_message.getText(),"Please first login");
        Driver.closeDriver();






    }

}
