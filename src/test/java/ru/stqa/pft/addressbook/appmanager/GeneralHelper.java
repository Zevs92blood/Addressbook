package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GeneralHelper {
    protected ChromeDriver driver;

    public GeneralHelper(ChromeDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String groupNameFromKonfig) {
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(groupNameFromKonfig);
    }
}
