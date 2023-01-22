package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day20_SoftAssertion {

    @Test
    public void softAssertTest() {

//      1. SoftAssert objesi olustur4
        SoftAssert softAssert = new SoftAssert();

        System.out.println("satir 15");
        softAssert.assertEquals(2,5); // FAIL

        System.out.println("satir 18");
        softAssert.assertTrue("JAVA".contains("U"));// FAIL

        System.out.println("satir 21");
        Assert.assertTrue(true);//PASS

        System.out.println("satir 24");
        softAssert.assertAll(); // PASS yada FAIL olarak assertion lari isaretler















    }
}
