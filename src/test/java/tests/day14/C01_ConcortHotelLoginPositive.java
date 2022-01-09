package tests.day14;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import utilities.TestBase;

public class C01_ConcortHotelLoginPositive extends TestBase {
    @Test
    public void positiveLoginTest() {
        // 	https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");

        ConcortHotelPage concortHotel=new ConcortHotelPage(driver);
        //	login butonuna bas
        concortHotel.login.click();
        concortHotel.userName.sendKeys("manager");
        concortHotel.password.sendKeys("Manager1!"+ Keys.ENTER);

        Assert.assertTrue(concortHotel.kaydedilenIsim.isEnabled(),"isim kaydedilemedi");

    }
    @Test
    public void negativeLoginTest() {
        // 	https://www.concorthotel.com/ adresine git
        driver.get("https://www.concorthotel.com/");

        ConcortHotelPage concortHotel=new ConcortHotelPage(driver);
        //	login butonuna bas
        concortHotel.login.click();
        concortHotel.userName.sendKeys("manager1");
        concortHotel.password.sendKeys("Manager1!"+ Keys.ENTER);

        Assert.assertTrue(concortHotel.basarisizKayit.isEnabled(),"isim kaydedilemedi");
    }

}
