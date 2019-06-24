package ru.stqa.pft.addressbook;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Konfig {



    public String useLinux;



    public Konfig() throws IOException {
         // this(ссылка на этот объект).атрибут = переменная, объявленная как аргумент функции
        File file = new File("./src/test/resources/config.properties"); //завод файла
        Properties properties = new Properties(); // Переменная для пропертей
        properties.load(new FileReader(file));
        String useLinux = properties.getProperty("useLinux");
        this.useLinux = useLinux;


    }
   // public String useLinux() {
     //   return this.useLinux;
    //}

}

