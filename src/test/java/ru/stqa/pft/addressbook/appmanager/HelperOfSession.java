package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.tech.Konfig;

public class HelperOfSession {
    private ChromeDriver driver;
    public HelperOfSession(ChromeDriver driver) {
        this.driver = driver;
    }
    public void login(Konfig konf) {
        driver.findElement(By.name("user")).click(); //вход в систему.
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(konf.userL);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(konf.userP);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]")).click();
    }
}
