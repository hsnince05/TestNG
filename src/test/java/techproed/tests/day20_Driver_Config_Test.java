package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class day20_Driver_Config_Test {

    @Test
    public void firstTest(){
        //amazona git
        //driver-->Driver.getDriver()
        // ConfigReader.getProperty("amazon_url") -->https://www.amazon.com
        Driver.getDriver().get(ConfigReader.getProperty("amazon_url")); // driver.get("https://www.amazon.com)

        //title in Amazon icerdigini kontrol et
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));

        //close driver
        Driver.closeDriver();

    }

}
