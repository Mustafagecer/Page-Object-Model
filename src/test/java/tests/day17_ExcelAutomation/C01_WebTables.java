package tests.day17_ExcelAutomation;

import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C01_WebTables {
    @Test
    public void test() throws InterruptedException {
        //Bir class oluşturun : C02_WebTables
        //● login() metodun oluşturun ve oturum açın.
        //● https://www.concorthotel.com//admin/HotelRoomAdmin adresine gidin
        //			○ Username : manager
        //			○ Password : Manager1!
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();

        qaConcortPage.hotelManagementLinki.click();
        qaConcortPage.hotelRoomsLinki.click();

        // 1. pages sayfasinda bir metod oluşturun : printData(int row, int column);

        String actualData= qaConcortPage.printData(2,5);
        //	 Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        //	hücredeki(cell) veriyi yazdırmalıdır.

        Driver.closeDriver();
    }
}
