package tests.smoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class negativeTest {
    // 1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
    //3 Farkli test Methodunda 3 senaryoyu test et
    //				- yanlisSifre
    QAConcortPage qaConcortPage;

    @Test (priority = -5)
    public void yanlisSifreIle(){
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));
        qaConcortPage=new QAConcortPage();
        qaConcortPage.loginButonu.click();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAvalidUsername"));
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInValidPassword")+ Keys.ENTER);
        Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed());
    }

    //				- yanlisKulllanici
    @Test (dependsOnMethods = "yanlisSifreIle")
    public void yanlisKulllaniciIle(){

        //Sayfa kapanmadigi icin kutucuklarin icindeki bilgileri silip yenilerini yazmaliyizh
        qaConcortPage=new QAConcortPage();
        qaConcortPage.usernameKutusu.clear();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword")+ Keys.ENTER);
        Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed());

    }
    //				- yanlisSifreKullanici
    @Test(dependsOnMethods = "yanlisSifreIle")
    public void yanlisSifreKullaniciIle() throws InterruptedException {

        qaConcortPage=new QAConcortPage();
        qaConcortPage.usernameKutusu.clear();
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAInvalidUsername"));
        qaConcortPage.passwordKutusu.clear();
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAInValidPassword")+ Keys.ENTER);
        Assert.assertTrue(qaConcortPage.loginFailedYazisi.isDisplayed());

        Driver.closeDriver();
    }

}
