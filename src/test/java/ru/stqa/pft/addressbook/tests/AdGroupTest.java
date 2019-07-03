package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.io.IOException;



public class AdGroupTest extends Baza {
  // для винды Windows users with Chocolatey installed: choco install chromedriver. Потом не понимаем, что этой винде ещё надо, психуем и укладываем драйверы в ресурсы. (./src/test/resources/)

  @Test
  public void adGroup() throws IOException {
    Konfig konf = new Konfig();
    app.getHelperOfNavigation().goToGroup();
    app.getHelperOfGroup().initGroup();
    app.getHelperOfGroup().fillingGroup(konf);
    app.getHelperOfGroup().submitGroup();
    app.getHelperOfGroup().returnToGroupPage();
  }

}

