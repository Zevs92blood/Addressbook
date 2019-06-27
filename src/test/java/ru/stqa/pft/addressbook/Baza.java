package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Baza {
    ChromeDriver driver; // Для линуха ставим sudo apt-get install chromium-chromedriver

    public static boolean isAlertPresent(ChromeDriver driver){
      try{
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;

      }
      }

    @BeforeMethod
    public void setUp() throws Exception {
      Konfig konf = new Konfig();
      // equals - сравнение для строк.
      if (konf.useLinux.equals("false")) System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe"); //обращение для винды.
      else System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver"); //обращение для линуха
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.get("http://192.168.56.101/addressbook/index.php");
      login(konf);
    }

    private void login(Konfig konf) {
      driver.findElement(By.name("user")).click(); //вход в систему.
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys(konf.userL);
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys(konf.userP);
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
    }

    protected void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    protected void submitGroup() {
      driver.findElement(By.name("submit")).click();
    }

    protected void fillingGroup(Konfig konf) {
      driver.findElement(By.name("group_name")).click();
      driver.findElement(By.name("group_name")).clear();
      driver.findElement(By.name("group_name")).sendKeys(konf.groupName);
      driver.findElement(By.name("group_header")).click();
      driver.findElement(By.name("group_header")).clear();
      driver.findElement(By.name("group_header")).sendKeys(konf.groupHeader);
      driver.findElement(By.name("group_footer")).click();
      driver.findElement(By.name("group_footer")).clear();
      driver.findElement(By.name("group_footer")).sendKeys(konf.groupFooter);
    }

    protected void initGroup() {
      driver.findElement(By.name("new")).click();
    }

    protected void goToGroup() {
      driver.findElement(By.linkText("groups")).click();
    }

    @AfterClass
    public void tearDown() {
      driver.quit();
    }
}
