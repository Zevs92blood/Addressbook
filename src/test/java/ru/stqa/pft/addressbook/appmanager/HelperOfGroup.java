package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.tech.Konfig;

public class HelperOfGroup {
    private ChromeDriver driver;
    public HelperOfGroup(ChromeDriver driver) {
        this.driver = driver;
    }

    public void returnToGroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    public void submitGroup() {
      driver.findElement(By.name("submit")).click();
    }

    public void fillingGroup(Konfig konf) {
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

    public void initGroup() {
      driver.findElement(By.name("new")).click();
    }

    public void deleteGroup() {
        driver.findElement(By.name("selected[]")).click();
        driver.findElement(By.name("delete")).click();
    }
}
