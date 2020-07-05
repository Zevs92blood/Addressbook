package ru.stqa.pft.addressbook.tech;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Konfig {


    //для ОС и Браузера
    public String useLinux;
    public String browser;
    public int browserSleeping;
    public String podopitnie;
    //для логина
    public String userL;
    public String userP;
    //для теста групп
    public String groupName;
    public String groupHeader;
    public String groupFooter;
    //для теста создания юзера
    public String first_name;
    public String middle_name;
    public String last_name;
    public String tNumH;
    public String tNumM;
    public String tNumW;
    public String bday;
    public String bmonth;
    public String year;
    public String groupNameForUser;
    //Повторение
    public String groupCount;
    public String groupFile;
    public String userCount;


    public Konfig() throws IOException {
         // this(ссылка на этот объект).атрибут = переменная, объявленная как аргумент функции
        System.out.println("Читаем проперти");
        File file = new File("./src/test/resources/config.properties"); //завод файла
        System.out.println("Разбираем файл проперти");
        Properties properties = new Properties(); // Переменная для пропертей
        properties.load(new FileReader(file));
        //для ОС
        String useLinux = properties.getProperty("useLinux");
        String browser = properties.getProperty("browser");
        int browserSleeping = Integer.parseInt(properties.getProperty("browserSleeping"));
        String podopitnie = properties.getProperty("podopitnie");
        //для логина
        String userL = properties.getProperty("userL");
        String userP = properties.getProperty("userP");
        //для теста групп
        String groupName = properties.getProperty("groupName");
        String groupHeader = properties.getProperty("groupHeader");
        String groupFooter = properties.getProperty("groupFooter");
        //для теста создания юзера
        String first_name = properties.getProperty("first_name");
        String middle_name = properties.getProperty("middle_name");
        String last_name = properties.getProperty("last_name");
        String tNumH = properties.getProperty("tNumH");
        String tNumM = properties.getProperty("tNumM");
        String tNumW = properties.getProperty("tNumW");
        String bday = properties.getProperty("bday");
        String bmonth = properties.getProperty("bmonth");
        String year = properties.getProperty("year");
        String groupNameForUser = properties.getProperty("groupNameForUser");
        //Повторение
        String groupFile = properties.getProperty("groupFile");
        String groupCount = properties.getProperty("groupCount");
        String userCount = properties.getProperty("userCount");


        //для ОС
        this.useLinux = useLinux;
        this.browser = browser;
        this.browserSleeping = browserSleeping;
        this.podopitnie = podopitnie;
        //для логина
        this.userL = userL;
        this.userP = userP;
        //для теста групп
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;
        //для теста создания юзера
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.tNumH = tNumH;
        this.tNumM = tNumM;
        this.tNumW = tNumW;
        this.bday = bday;
        this.bmonth = bmonth;
        this.year = year;
        this.groupNameForUser = groupNameForUser;
        //Повторение
        this.groupCount = groupCount;
        this.groupFile = groupFile;
        this.userCount = userCount;






    }
   // public String useLinux() {
     //   return this.useLinux;
    //}

}

