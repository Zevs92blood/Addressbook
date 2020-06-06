package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.tech.GData;
import ru.stqa.pft.addressbook.tech.UData;
import ru.stqa.pft.addressbook.tech.Konfig;
import ru.stqa.pft.addressbook.appmanager.AppManager;

import java.util.Comparator;
import java.util.List;

public class Baza {

    protected static final AppManager app = new AppManager();

    @BeforeSuite
    public void setUp() throws Exception {
        Konfig konf = new Konfig();
        // equals - сравнение для строк.
        if (konf.browser.equals("chrome")) {
            if (konf.useLinux.equals("false"))
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe"); //обращение для винды.
            else
                System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver"); //обращение для линуха
        } else {
            if (konf.useLinux.equals("false"))
                System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe"); //обращение для винды.
            else
                System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver"); //обращение для линуха
        }
        app.init(konf);
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public void proverkaNaCelostnostVsegoOstalnogoG(List<GData> ranee, List<GData> potom) {
        Comparator<? super GData> byName = (g1, g2) -> (g1.getName().compareTo(g2.getName())); //лямда для сорторовки по имени
        Comparator<? super GData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()); //лямбда для сортировки по ID
        ranee.sort(byId);
        potom.sort(byId);
        Assert.assertEquals(potom, ranee);
    }

    public void proverkaNaCelostnostVsegoOstalnogoU(List<UData> ranee, List<UData> potom) {
        Comparator<? super UData> byFName = (g1, g2) -> (g1.getfName().compareTo(g2.getfName())); //лямда для сорторовки по имени
        Comparator<? super UData> byLName = (g1, g2) -> (g1.getlName().compareTo(g2.getlName())); //лямда для сорторовки по Фамилии
        Comparator<? super UData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId()); //лямбда для сортировки по ID
        ranee.sort(byId);
        potom.sort(byId);
        Assert.assertEquals(potom, ranee);
    }
}
