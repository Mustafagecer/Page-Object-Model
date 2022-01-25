package tests.GMIBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GMILoginPage;
import utilities.*;

public class JSUtilsTests extends TestBase {

    @Test
    public void scrollIntoViewTest(){
        Driver.getDriver().get(ConfigReader.getProperty("GMIUrl"));
        WebElement pricingPlan = Driver.getDriver().findElement(By.xpath("//*[.='Pricing Plan']"));
        JSUtils.scrollIntoViewJS(pricingPlan);
        Assert.assertTrue(pricingPlan.isEnabled());
    }
    @Test
    public void clickWithJSTest(){
        //JSclick works better than selenium click
        GMILoginPage gmiLoginPage=new GMILoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("GMIUrl"));
        ReusableMethods.waitFor(3);
        JSUtils.clickElementByJS(gmiLoginPage.loginDropdown);
        JSUtils.clickElementByJS(gmiLoginPage.signInButton );
    }

    @Test
    public void scrollDownTheTest(){
        Driver.getDriver().get(ConfigReader.getProperty("GMIUrl"));
        JSUtils.scrollDownByJS();
        WebElement theLastHome=Driver.getDriver().findElement(By.xpath("//a[contains(text(),'Home')]"));
        Assert.assertTrue(theLastHome.isEnabled());

    }
    @Test
    public void flashTest(){
        GMILoginPage gmiLoginPage=new GMILoginPage();
        Driver.getDriver().get(ConfigReader.getProperty("GMIUrl"));
        JSUtils.clickElementByJS(gmiLoginPage.loginDropdown);
        JSUtils.clickElementByJS(gmiLoginPage.signInButton);
        JSUtils.flash(gmiLoginPage.loginButton);

    }

}
