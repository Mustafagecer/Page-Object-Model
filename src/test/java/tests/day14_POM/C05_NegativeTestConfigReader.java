package tests.day14_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C05_NegativeTestConfigReader extends TestBase {
    @Test
    public void test(){
        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotelPage=new ConcortHotelPage(driver);
        concortHotelPage.login.click();
        concortHotelPage.userName.sendKeys(ConfigReader.getProperty("CHInvalidUsername"));
        concortHotelPage.password.sendKeys(ConfigReader.getProperty("CHValidPassword")+ Keys.ENTER);

        Assert.assertTrue(concortHotelPage.basarisizKayit.isEnabled() );
    }
}
