package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperOfNavigation extends GeneralHelper {

    public HelperOfNavigation(WebDriver driver) {
        super(driver);
    }

    public void goToGroup() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));

    }

    public void goToHome() {
        if (isElementPresent(By.tagName("strong"))
                && driver.findElement(By.tagName("strong")).getText().equals("Number of results:")
                && isElementPresent(By.tagName("add"))) {
            return;
        }
        click(By.linkText("home"));

    }


}
