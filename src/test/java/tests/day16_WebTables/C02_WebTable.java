package tests.day16_WebTables;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAConcortPage;
import utilities.Driver;

public class C02_WebTable {

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

        //● table() metodu oluşturun
        //			○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody


        int basliklarListesiNo=1;
        for (WebElement each:qaConcortPage.basliklarListesi
             ) {
            System.out.println(basliklarListesiNo+" = "+each.getText());
            basliklarListesiNo++;
            
        }

        //			○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.

        System.out.println(qaConcortPage.tBodyTumu.getText());

        Assert.assertTrue(qaConcortPage.tBodyTumu.getText().contains("Star Hotel"));


        // Eger tum tablo body'sini hucrelere ayirmadan tek bir String olarak gormek istersek
        // tum body'i tek bir Webelement olarak locate edebiliriz
        // Bu yklasim, tabloda HAPPY HOTEL var mi gibi sorular icin ideal bir cozum olur

        //● printRows() metodu oluşturun //tr
        //			○ table body’sinde bulunan toplam satir(row) sayısını bulun.

        System.out.println("Tablodaki sütun sayisi: "+ qaConcortPage.satirlarListesi.size());

        int satirlarListesiNo=1;
        for (WebElement each : qaConcortPage.satirlarListesi
             ) {
            if (satirlarListesiNo==4){
                System.out.println(satirlarListesiNo+" = "+each.getText());
            }
            satirlarListesiNo++;

        }
        int dorduncuSutunListesiNo=1;
        for (WebElement each:qaConcortPage.dorduncuSutunListesi
             ) {
            System.out.println(dorduncuSutunListesiNo+" = "+each.getText());
            dorduncuSutunListesiNo++;


        }

        int yedinciSutunListesiNo=1;
        for (WebElement each:qaConcortPage.yedinciSutunListesi
        ) {
            System.out.println(yedinciSutunListesiNo+" = "+each.getText());
            yedinciSutunListesiNo++;


        }


        Driver.closeDriver();

    }
}
