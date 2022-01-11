package tests.smoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.ConfigReader;
import utilities.Driver;

public class positiveLoginTest {
    @Test
    public void positiveLoginTest(){
        //Bir test method olustur positiveLoginTest()
        //https://qa-environment.concorthotel.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("CHQAUrl"));



        //login butonuna bas
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ilkLoginLinki.click();

        //test data username: manager ,
        qaConcortPage.usernameKutusu.sendKeys(ConfigReader.getProperty("CHQAvalidUsername"));

        //test data password : Manager1!
        qaConcortPage.passwordKutusu.sendKeys(ConfigReader.getProperty("CHQAValidPassword")+ Keys.ENTER);
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Assert.assertTrue(qaConcortPage.basariliGirisYaziElementi.isDisplayed(),"Yeni kayit olusturalamaadi");



    }
}
