package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class GeneralHelper {
    protected WebDriver driver;

    public GeneralHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String NameFromKonfig) {
        click(locator);
        if (NameFromKonfig != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (! NameFromKonfig.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(NameFromKonfig);
            }
        }
    }
    //protected void spisok(By locator, String textOfSpisok) {

       // new Select(driver.findElement(locator)).selectByVisibleText(textOfSpisok);

    //}
    protected void fullSpisok(By locator, String textOfSpisok, By xpathLoc) {
        click(locator);
        new Select(driver.findElement(locator)).selectByVisibleText(textOfSpisok);
        //spisok(locator, pinOfSpisok); //на выбор влияет и следующая строчка
        click(xpathLoc);
    }

    public void acceptButtonOfAlert() {
        driver.switchTo().alert().accept();
    }
    public void pinFirstAvailable() {
        click(By.name("selected[]"));

    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void backToHP() {
        click(By.linkText("home page"));
    }
}


