package tests.GMIBank;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.GMIEmployeeDefaultPage;
import pages.GMILoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CustomerCreateAsEmployee {
    GMILoginPage gmiLoginPage=new GMILoginPage();
    GMIEmployeeDefaultPage gmiEmployeeDefaultPage=new GMIEmployeeDefaultPage();
    Faker faker=new Faker();


    @Test
    public void creatingEmployeeAsAdmin(){
        Driver.getDriver().get(ConfigReader.getProperty("GMIUrl"));
        gmiLoginPage.loginApplication("gino.wintheiser","%B6B*q1!TH");
        gmiEmployeeDefaultPage.myOperationDropDown.click();
        gmiEmployeeDefaultPage.manageCustomer.click();
        gmiEmployeeDefaultPage.createNewCustomerButton.click();
        gmiEmployeeDefaultPage.ssnBox1.sendKeys(faker.idNumber().ssnValid());
        gmiEmployeeDefaultPage.firstname.sendKeys(faker.name().firstName());
        gmiEmployeeDefaultPage.lastname.sendKeys(faker.name().lastName());
        gmiEmployeeDefaultPage.middleInitial.sendKeys(faker.name().nameWithMiddle());
        gmiEmployeeDefaultPage.email.sendKeys(faker.internet().emailAddress());
        gmiEmployeeDefaultPage.mobilePhoneNumber.sendKeys("111-111-1111");
        gmiEmployeeDefaultPage.phoneNumber.sendKeys("111-111-1111");
        gmiEmployeeDefaultPage.zipCode.sendKeys(faker.address().zipCode());
        gmiEmployeeDefaultPage.address.sendKeys(faker.address().fullAddress());
        gmiEmployeeDefaultPage.city.sendKeys(faker.address().city());
        gmiEmployeeDefaultPage.ssn2.sendKeys(faker.idNumber().ssnValid());
        gmiEmployeeDefaultPage.countryDropdown.sendKeys("Poland"+Keys.ENTER);
        gmiEmployeeDefaultPage.state.sendKeys(faker.address().state());
        gmiEmployeeDefaultPage.userDrop.sendKeys("tom"+Keys.ENTER);
        gmiEmployeeDefaultPage.zelleEnrolledCheckbox.click();
        gmiEmployeeDefaultPage.saveButton.click();








    }
    @AfterClass
    public  void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        Driver.closeDriver();
    }

}
