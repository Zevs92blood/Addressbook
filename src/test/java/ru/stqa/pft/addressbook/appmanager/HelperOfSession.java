package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.tech.Konfig;

public class HelperOfSession extends GeneralHelper {

    public HelperOfSession(WebDriver driver) {
        super(driver);
    }
    public void login(Konfig konf) {
        type(By.name("user"), konf.userL); //вход в систему.
        type(By.name("pass"), konf.userP);
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::input[2]"));

    }
}
