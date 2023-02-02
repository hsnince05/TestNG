package techproed.tests;

import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_TechproLoginTest {

//https://testcenter.techproeducation.com/index.php?page=form-authentication
//Page object Model kullanarak sayfaya giriş yapildigini test edin
//Sayfadan cikis yap ve cikis yapildigini test et
//techproed
//SuperSecretPassword
//TechproLoginPage
//userName
//password
//submitButton
//TechproHomePage
//homeHeader
//homeLogoutButton
//TEST:
//Class: TechproLoginTest
//Metot : loginTest()

    TechproLoginPage techproLoginPage;
    TechproHomePage techproHomePage;

    @Test(groups = "regression-tests")
    public void loginTest(){

        techproLoginPage =new TechproLoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("techpro_url"));

        techproLoginPage.username.sendKeys(ConfigReader.getProperty("open_techpro_username"));
        techproLoginPage.password.sendKeys(ConfigReader.getProperty("open_techpro_password"));
        techproLoginPage.submit.click();

        techproHomePage= new TechproHomePage();

        assert techproHomePage.anaSayfaText.isDisplayed();
        techproHomePage.logOut.click();

        techproLoginPage.LoginPage.isDisplayed();

        Driver.closeDriver();


    }
}
