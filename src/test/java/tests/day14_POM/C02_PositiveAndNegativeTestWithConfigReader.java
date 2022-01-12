package tests.day14_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class C02_PositiveAndNegativeTestWithConfigReader extends TestBase {
    @Test
    public void positiveTestConfig(){

        driver.get(ConfigReader.getProperty("CHUrl"));
        ConcortHotelPage concortHotel=new ConcortHotelPage(driver);
        concortHotel.login.click();
        concortHotel.userName.sendKeys(ConfigReader.getProperty("CHvalidUsername"));
        concortHotel.password.sendKeys(ConfigReader.getProperty("CHValidPassword")+ Keys.ENTER);
        Assert.assertTrue(concortHotel.kaydedilenIsim.isEnabled(),"giris basarisiz");
    }


}
