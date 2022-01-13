package tests.day19;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class C02_WindowHandleRaporlu extends TestBaseRapor {
    @Test
    public void test()  {
        extentTest=extentReports.createTest("window hanle test","yeni sayfada new window yazisini test eder");
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("istenen adrese gidildi");

        Driver.getDriver().findElement(By.linkText("Click Here")).click();

        extentTest.info("linke tiklanda");
        ReusableMethods.switchToWindow("New Window");
        extentTest.info("yeni sayfaya gecildi");

        WebElement newWindowYaziElementi=Driver.getDriver().findElement(By.tagName("h3"));
        extentTest.info("test edilecek yazi locate edildi");
        Assert.assertTrue(!newWindowYaziElementi.isDisplayed());
        extentTest.pass("yazinin gorunur oldugu test edildi");
        //extentTest.pass yazarsak bize tetin basarili olup olmadigini soyler
        //extentTest.info yazarsak sadece bizi boyle bir testin yapildigini soyler
        //herhangi bir test gecmemisse ekran goruntusu verir


    }
}
