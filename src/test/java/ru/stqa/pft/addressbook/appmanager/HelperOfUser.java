package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.tech.UData;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.util.ArrayList;
import java.util.List;

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

    public void writeUserData(Konfig konf, boolean nado) {
        System.out.println("Забиваем данные юзера");
        type(By.name("firstname"), konf.first_name);
        type(By.name("middlename"), konf.middle_name);
        type(By.name("lastname"), konf.last_name);
        tikaemSpisok(By.name("bday"), konf.bday, true);
        tikaemSpisok(By.name("bmonth"), konf.bmonth, true);
        //fullSpisok(By.name("bday"), "3", By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[5]"));
        //fullSpisok(By.name("bmonth"), "February", By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[36]"));
        type(By.name("byear"), konf.year);
        tikaemSpisok(By.name("new_group"), konf.groupNameForUser, nado);



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

    public List<UData> getUserList() {
        List<UData> users = new ArrayList<UData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("td.center"));
        for (WebElement element : elements) {
            String fName = element.findElement(By.tagName("input")).getAttribute("title");
            
            String lName = element.findElement(By.tagName("input")).getAttribute("title");
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            UData user = new UData(fName, lName, id);
            users.add(user);
        }
        return users;
    }
}




