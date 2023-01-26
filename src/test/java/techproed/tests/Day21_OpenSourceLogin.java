package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourceDashboardPage;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_OpenSourceLogin {

//    https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//    Page Class : OpenSourcePage
//    kullaniciAdi, kullaniciSifre, submitButton elementlerini bul
//    Test Class : OpenSourceLogin
//    Page objesi olustur
//    Login Testini basarili oldugunu test et


    @Test
    public void openSourceLogin() throws InterruptedException {

       //  1. Sayfaya git
       // Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("open_source_url"));

        //  2. Page objesi Olustur
        OpenSourcePage openSourcePage = new OpenSourcePage();

        //  3. Bu objeyi kullanarak o classdaki objelere ulas
        openSourcePage.username.sendKeys(ConfigReader.getProperty("open_source_username"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("open_source_password"));
        openSourcePage.submitButton.click();

        //  4. Assertion
        OpenSourceDashboardPage openSourceDashboardPage = new OpenSourceDashboardPage();
        Thread.sleep(5000);
        Assert.assertTrue(openSourceDashboardPage.dashboardHeader.isDisplayed());

        Driver.closeDriver();
    }

}
