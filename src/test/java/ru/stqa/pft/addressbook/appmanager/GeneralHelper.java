package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GeneralHelper {
    protected WebDriver driver;

    public GeneralHelper(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
        System.out.println("Клик");
    }

    protected void type(By locator, String NameFromKonfig) {
        System.out.println("Тыкаемся в поле " + locator);
        click(locator);
        if (NameFromKonfig != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (!NameFromKonfig.equals(existingText)) {
                driver.findElement(locator).clear();
                System.out.println("Очищаем поле");
                driver.findElement(locator).sendKeys(NameFromKonfig);
                System.out.println("Заполняем поле");
            } else {
                System.out.println("Нужное зачение уже есть");
            }
        }
    }
    //protected void spisok(By locator, String textOfSpisok) {

    // new Select(driver.findElement(locator)).selectByVisibleText(textOfSpisok);

    //}


    public void tikaemSpisok(By locator, String textOfSpisok, boolean create) {
        System.out.println("Тыкаемся в поле " + locator);
        if (create) {
            try {
                System.out.println("Доступное значение?");
                new Select(driver.findElement(locator)).selectByVisibleText(textOfSpisok);
                System.out.println("Есть!");
            } catch (NullPointerException ex) {
                System.out.println("Не задано");
            } catch (NoSuchElementException ex) {
                System.out.println("Нет доступного в списке");
                System.out.println("А есть ли список?");
                driver.findElement(locator); // Если списка на странице нет, а он должен быть, тест должен упасть в этом месте.
                System.out.println("Есть!");

            }
        } else {
            Assert.assertFalse(isElementPresent(locator)); // Если список на странице есть, а быть его не должно, тест должен упасть в этом месте.
        }

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


