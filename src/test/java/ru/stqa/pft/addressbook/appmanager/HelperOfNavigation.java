package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperOfNavigation {
    private ChromeDriver driver;
    public HelperOfNavigation(ChromeDriver driver) {
        this.driver = driver;
    }

    public void goToGroup() {
      driver.findElement(By.linkText("groups")).click();
    }
}
