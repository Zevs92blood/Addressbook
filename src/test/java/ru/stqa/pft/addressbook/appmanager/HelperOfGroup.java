package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.tech.GData;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.util.ArrayList;
import java.util.List;

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

private List<GData> gCache = null;


    public List<GData> getGroupList() {
        if (gCache != null) {
            return gCache;
        }
        List<GData> groups = new ArrayList<GData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GData group = new GData(name, id);
            groups.add(group);
        }
        gCache = groups;
        return groups;
    }
}
