package ru.stqa.pft.addressbook.tests;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.GData;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class AdGroupTest extends Baza {
    // для винды Windows users with Chocolatey installed: choco install chromedriver. Потом не понимаем, что этой винде ещё надо, психуем и укладываем драйверы в ресурсы. (./src/test/resources/)

    @DataProvider
    public Iterator<Object[]> valid() throws IOException {
        Konfig konf = new Konfig();
        BufferedReader reader = new BufferedReader(new FileReader(new File(konf.groupFile)));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<GData> group = gson.fromJson(json, new TypeToken<List<GData>>() {
        }.getType()); // по логике List<GData>.class
        return group.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }


    @Test(dataProvider = "valid")
    public void adGroupN(GData groups) throws IOException {
        app.getHelperOfNavigation().goToGroup();
        List<GData> ranee = app.getHelperOfGroup().getGroupList();
        app.getHelperOfGroup().initGroup();
        GData group = new GData(groups.getName());
        app.getHelperOfGroup().fillingGroup(groups);
        app.getHelperOfGroup().submitGroup();
        app.getHelperOfGroup().returnToGroupPage();
        List<GData> potom = app.getHelperOfGroup().getGroupList();
        Assert.assertEquals(potom.size(), ranee.size() + 1);
        ranee.add(group);
        proverkaNaCelostnostVsegoOstalnogoG(ranee, potom);


        // @Test
        // public void adGroup() throws IOException {
        //   Konfig konf = new Konfig();
        //  app.getHelperOfNavigation().goToGroup();
        //  List<GData> ranee = app.getHelperOfGroup().getGroupList();
        // app.getHelperOfGroup().initGroup();
        //  GData group = new GData(konf.groupName);
        //  app.getHelperOfGroup().fillingGroup(konf);
        //  app.getHelperOfGroup().submitGroup();
        //   app.getHelperOfGroup().returnToGroupPage();
        //   List<GData> potom = app.getHelperOfGroup().getGroupList();
        //   Assert.assertEquals(potom.size(), ranee.size() + 1);
//ranee.add(group);

        //  proverkaNaCelostnostVsegoOstalnogoG(ranee, potom);

    }

}

