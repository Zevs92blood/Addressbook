package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.tech.Konfig;

public class HelperOfGroup extends GeneralHelper{
    public HelperOfGroup(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroup() {
        click(By.name("submit"));
    }

    public void fillingGroup(Konfig konf) {
        type(By.name("group_name"), konf.groupName);
        type(By.name("group_header"), konf.groupHeader);
        type(By.name("group_footer"), konf.groupFooter);
    }

    public void initGroup() {
        click(By.name("new"));
    }

    public void deleteGroup() {

        click(By.name("delete"));
    }

    public void editGroup() {

        click(By.name("edit"));
    }

    public void updateGroup() {
        click(By.name("update"));
    }

    public void createG(Konfig konf) {
        initGroup();
        fillingGroup(konf);
        submitGroup();
        returnToGroupPage();
    }

    public boolean seartchG() {
        return isElementPresent(By.name("selected[]"));
    }
}
