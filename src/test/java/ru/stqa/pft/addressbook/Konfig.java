package ru.stqa.pft.addressbook;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Konfig {


    //для ОС
    public String useLinux;
    //для логина
    public String userL;
    public String userP;
    //для теста групп
    public String groupName;
    public String groupHeader;
    public String groupFooter;



    public Konfig() throws IOException {
         // this(ссылка на этот объект).атрибут = переменная, объявленная как аргумент функции
        File file = new File("./src/test/resources/config.properties"); //завод файла
        Properties properties = new Properties(); // Переменная для пропертей
        properties.load(new FileReader(file));
        String useLinux = properties.getProperty("useLinux");
        String userL = properties.getProperty("userL");
        String userP = properties.getProperty("userP");
        String groupName = properties.getProperty("groupName");
        String groupHeader = properties.getProperty("groupHeader");
        String groupFooter = properties.getProperty("groupFooter");
        this.useLinux = useLinux;
        this.userL = userL;
        this.userP = userP;
        this.groupName = groupName;
        this.groupHeader = groupHeader;
        this.groupFooter = groupFooter;




    }
   // public String useLinux() {
     //   return this.useLinux;
    //}

}

