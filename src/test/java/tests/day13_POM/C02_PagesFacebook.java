package tests.day13_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.TestBase;

public class C02_PagesFacebook extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.facebook.com/");
        FacebookPage facebookPage=new FacebookPage(driver);
        facebookPage.cookies();
        facebookPage.mailKutusu.sendKeys("techproed@hotmail.com");
        facebookPage.sifreKutusu.sendKeys("12345");
        facebookPage.loginTusu.click();
        Assert.assertTrue(facebookPage.failedYazisi.isEnabled());

    }

}
