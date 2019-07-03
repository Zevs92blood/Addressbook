package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.tech.Konfig;
import ru.stqa.pft.addressbook.appmanager.AppManager;

public class Baza {

    protected final AppManager app = new AppManager();

    @BeforeMethod
    public void setUp() throws Exception {
      Konfig konf = new Konfig();
      // equals - сравнение для строк.
      if (konf.useLinux.equals("false")) System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe"); //обращение для винды.
      else System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver"); //обращение для линуха
        app.init(konf);
    }

    @AfterClass
    public void tearDown() {
        app.stop();
    }

}
