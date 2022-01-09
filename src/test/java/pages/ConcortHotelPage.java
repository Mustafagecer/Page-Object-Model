package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConcortHotelPage {
    WebDriver driver;
    public ConcortHotelPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public ConcortHotelPage(){

    }
    @FindBy(id = "navLogon")
    public WebElement login;

    @FindBy(id = "UserName")
    public WebElement userName;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(xpath= "(//td[@class='sorting_1'])[1]")
    public WebElement kaydedilenIsim;

    @FindBy(className = "validation-summary-errors")
    public WebElement basarisizKayit;
}
