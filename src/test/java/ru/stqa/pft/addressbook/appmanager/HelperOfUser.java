package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.tech.Konfig;

public class HelperOfUser extends GeneralHelper {

    public HelperOfUser(ChromeDriver driver) {
        super(driver);
    }

    public void createUser() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));

    }

    public void initUser() {
        click(By.linkText("add new"));

    }

    public void writeUserData(Konfig konf) {
        type(By.name("firstname"), konf.first_name);
        type(By.name("middlename"), konf.middle_name);
        type(By.name("lastname"), konf.last_name);
        fullSpisok(By.name("bday"), "3", By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[5]"));
        fullSpisok(By.name("bmonth"), "February", By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[36]"));
        type(By.name("byear"), konf.year);

    }


    public void pinUser() {
        click(By.name("selected[]"));

    }

    public void pushDelButton() {
        click(By.xpath("//input[@value='Delete']"));
    }
}


