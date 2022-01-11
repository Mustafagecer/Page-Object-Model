package tests.day15;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_E2ETest {
    @Test
    public void test() throws InterruptedException {

        // 1. Tests packagenin altına class olusturun: C02_CreateHotel
        //2. Bir metod olusturun: createHotel
        //3. https://qa-environment.concorthotel.com/ adresine git.


        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelListLink.click();
        qaConcortPage.addHotelLink.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.


        Faker faker=new Faker();
        Actions actions=new Actions(Driver.getDriver());
        qaConcortPage.addHotelCodeKutusu.click();
        actions.
                click(qaConcortPage.addHotelCodeKutusu)
                .sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.TAB)



        //8. Save butonuna tıklayın.
                .sendKeys(Keys.ENTER)
                .perform();
        //9. “Hotel was inserted successfully” textinin göründüğünü test edin.

        Assert.assertTrue(qaConcortPage.addHotelSuccesfullYazisi.isEnabled(),"addHotelSuccesfullYazisi aktif degil");
        //Driver.getDriver().switchTo().alert().accept();


        //10. OK butonuna tıklayın.


        Thread.sleep(4000);
        qaConcortPage.addHotelAllertOk.click();
        Driver.closeDriver();
    }
}
