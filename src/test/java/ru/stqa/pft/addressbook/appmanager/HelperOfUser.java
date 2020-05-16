package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.tech.Konfig;

public class HelperOfUser extends GeneralHelper {

    public HelperOfUser(WebDriver driver) {
        super(driver);
    }

    public void createUser() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));

    }

    public void initUser() {
        click(By.linkText("add new"));

    }

    public void writeUserData(Konfig konf, boolean create) {
        System.out.println("Забиваем данные юзера");
        type(By.name("firstname"), konf.first_name);
        type(By.name("middlename"), konf.middle_name);
        type(By.name("lastname"), konf.last_name);
        tikaemSpisok(By.name("bday"), konf.bday);
        tikaemSpisok(By.name("bmonth"), konf.bmonth);
        //fullSpisok(By.name("bday"), "3", By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[5]"));
        //fullSpisok(By.name("bmonth"), "February", By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[36]"));
        type(By.name("byear"), konf.year);
        System.out.println("Тыкаемся в группу");
        if (create) {
            try {
                System.out.println("Доступная группа?");
                tikaemSpisok(By.name("new_group"), konf.groupNameForUser);
                System.out.println("Есть!");
            } catch (NullPointerException ex){
                System.out.println("Не задана группа");
            } catch (NoSuchElementException ex){
                System.out.println("Нет доступной группы");
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));}


    }


    public void pushDelButton() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void pushEditButton() {
        click(By.xpath("//img[@alt='Edit']"));
    }
    public void updateUser() {
        click(By.name("update"));
    }

    public void createU(Konfig konf) {
        initUser();
        writeUserData(konf, true);
        createUser();
        backToHP();

    }

    public boolean seartchU() {
        return isElementPresent(By.name("selected[]"));
    }
}




