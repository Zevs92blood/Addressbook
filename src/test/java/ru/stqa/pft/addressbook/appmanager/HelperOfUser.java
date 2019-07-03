package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.tech.Konfig;

public class HelperOfUser {
    private ChromeDriver driver;
    public HelperOfUser(ChromeDriver driver) {
        this.driver = driver;
    }

    public void createUser() {
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]")).click();
    }

    public void initUser() {
      driver.findElement(By.linkText("add new")).click();
    }

    public void writeUserData(Konfig konf) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).clear();
      driver.findElement(By.name("firstname")).sendKeys(konf.first_name);
      driver.findElement(By.name("middlename")).click();
      driver.findElement(By.name("middlename")).clear();
      driver.findElement(By.name("middlename")).sendKeys(konf.middle_name);
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).clear();
      driver.findElement(By.name("lastname")).sendKeys(konf.last_name);
      driver.findElement(By.name("bday")).click();
      new Select(driver.findElement(By.name("bday"))).selectByVisibleText("1");
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[3]")).click();
      driver.findElement(By.name("bmonth")).click();
      new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText("January");
      driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[35]")).click();
      driver.findElement(By.name("byear")).click();
      driver.findElement(By.name("byear")).clear();
      driver.findElement(By.name("byear")).sendKeys("2000");
    }
}
