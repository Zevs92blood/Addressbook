package ru.stqa.pft.addressbook.tests;



import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.GData;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.io.IOException;
import java.util.List;


public class AdGroupTest extends Baza {
  // для винды Windows users with Chocolatey installed: choco install chromedriver. Потом не понимаем, что этой винде ещё надо, психуем и укладываем драйверы в ресурсы. (./src/test/resources/)

  @Test
  public void adGroup() throws IOException {
    Konfig konf = new Konfig();
    app.getHelperOfNavigation().goToGroup();
    List<GData> ranee = app.getHelperOfGroup().getGroupList();
    app.getHelperOfGroup().initGroup();
    GData group = new GData(konf.groupName);
    app.getHelperOfGroup().fillingGroup(konf);
    app.getHelperOfGroup().submitGroup();
    app.getHelperOfGroup().returnToGroupPage();
    List<GData> potom = app.getHelperOfGroup().getGroupList();
    Assert.assertEquals(potom.size(), ranee.size() + 1);
ranee.add(group);

    proverkaNaCelostnostVsegoOstalnogoG(ranee, potom);

  }

}

