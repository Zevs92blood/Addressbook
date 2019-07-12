package ru.stqa.pft.addressbook.tech;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Konfig {


    //для ОС и Браузера
    public String useLinux;
    public String browser;
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
    public String year;


    public Konfig() throws IOException {
         // this(ссылка на этот объект).атрибут = переменная, объявленная как аргумент функции
        File file = new File("./src/test/resources/config.properties"); //завод файла
        Properties properties = new Properties(); // Переменная для пропертей
        properties.load(new FileReader(file));
        //для ОС
        String useLinux = properties.getProperty("useLinux");
        String browser = properties.getProperty("browser");
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
        String year = properties.getProperty("year");


        //для ОС
        this.useLinux = useLinux;
        this.browser = browser;
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
        this.year = year;





    }
   // public String useLinux() {
     //   return this.useLinux;
    //}

}

