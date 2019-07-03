package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.tech.Konfig;

public class HelperOfGroup extends GeneralHelper{
    public HelperOfGroup(ChromeDriver driver) {
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
        click(By.name("selected[]"));
        click(By.name("delete"));
    }
}
