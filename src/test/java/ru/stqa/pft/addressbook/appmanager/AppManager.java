package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.util.concurrent.TimeUnit;

public class AppManager {

    private HelperOfNavigation helperOfNavigation;
    private HelperOfUser helperOfUser;
    private HelperOfGroup helperOfGroup;
    private HelperOfSession helperOfSession;
    WebDriver driver; // Для линуха ставим sudo apt-get install chromium-chromedriver

    public static boolean isAlertPresent(ChromeDriver driver){
      try{
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;

      }
      }

    public void init(Konfig konf) {
        if (konf.browser.equals("chrome")) {driver = new ChromeDriver();}
        else {driver = new FirefoxDriver();}
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://192.168.56.101/addressbook/index.php");
        helperOfGroup = new HelperOfGroup(driver);
        helperOfUser = new HelperOfUser(driver);
        helperOfNavigation = new HelperOfNavigation(driver);
        helperOfSession = new HelperOfSession(driver);
        helperOfSession.login(konf);
    }



    public void stop() {
        driver.quit();
    }

    public HelperOfGroup getHelperOfGroup() {
        return helperOfGroup;
    }

    public HelperOfUser getHelperOfUser() {
        return helperOfUser;
    }


    public HelperOfNavigation getHelperOfNavigation() {
        return helperOfNavigation;
    }
}
