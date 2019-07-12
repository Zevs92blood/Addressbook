package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperOfNavigation extends GeneralHelper {

    public HelperOfNavigation(WebDriver driver) {
        super(driver);
    }

    public void goToGroup() {
        click(By.linkText("groups"));

    }
}
