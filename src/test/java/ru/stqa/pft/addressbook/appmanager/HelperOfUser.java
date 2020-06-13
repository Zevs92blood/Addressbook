package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        uCache = null;
    }

    public void initUser() {
        click(By.linkText("add new"));

    }

    public void writeUserData(Konfig konf, boolean nado) {
        System.out.println("Забиваем данные юзера");
        type(By.name("firstname"), konf.first_name);
        type(By.name("middlename"), konf.middle_name);
        type(By.name("lastname"), konf.last_name);
        type(By.name("home"), konf.tNumH);
        type(By.name("mobile"), konf.tNumM);
        type(By.name("work"), konf.tNumW);
        tikaemSpisok(By.name("bday"), konf.bday, true);
        tikaemSpisok(By.name("bmonth"), konf.bmonth, true);
        //fullSpisok(By.name("bday"), "3", By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[5]"));
        //fullSpisok(By.name("bmonth"), "February", By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Birthday:'])[1]/following::option[36]"));
        type(By.name("byear"), konf.year);
        tikaemSpisok(By.name("new_group"), konf.groupNameForUser, nado);


    }


    public void pushDelButton() {
        click(By.xpath("//input[@value='Delete']"));
        uCache = null;
    }

    public void pushDetailsButton(int index) {
        if (index != 0) {
            index++;
            driver.findElement(By.xpath("(//img[@alt='Details'])[" + index + "]")).click();
        } else click(By.xpath("//img[@alt='Details']"));
    }
    public void pushEditButton(int index) {
        if (index != 0) {
            index++;
        driver.findElement(By.xpath("(//img[@alt='Edit'])[" + index + "]")).click();
        } else click(By.xpath("//img[@alt='Edit']"));
    }

    public void updateUser() {
        click(By.name("update"));
        uCache = null;
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

    private List<UData> uCache = null;

    public List getDetails() {
        List tUN = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.id("content"));
       for (WebElement element : elements) {
        List<WebElement> uFullData = driver.findElements(By.cssSelector("#text"));
       String h = uFullData.get(1).toString();
       String m = uFullData.get(2).toString();
       String w = uFullData.get(3).toString();
       tUN.add(h);
           tUN.add(m);
           tUN.add(w);

       }
       return tUN;
    }

    public List<UData> getUserList() {
        if (uCache != null){
            return uCache;
        }
        List<UData> users = new ArrayList<UData>();
        List<WebElement> elements = driver.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> yacheika = element.findElements(By.tagName("td"));
            try {
                String fName = yacheika.get(2).getText();
                String lName = yacheika.get(1).getText();
                String tNum = yacheika.get(5).getText();
                //String[] words = fName.split(" "); // разбираем полученное по пробелу
                //fName = words[1].substring(1); //выдираю 2 слово. удаляю скобку "("
                //String lName = words[2].substring(0, words[2].length() - 1); //выдираю 3 слово. удаляю скобку ")"
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                UData user = new UData(fName, lName, tNum, id);
                users.add(user);
            } catch (NoSuchElementException ex){
                System.out.println("найден лишний элемент");
            }

        }
        uCache = users;
        return users;
    }
}




