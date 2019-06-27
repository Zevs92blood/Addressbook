package ru.stqa.pft.addressbook;



import org.testng.annotations.Test;

import java.io.IOException;



public class AdGroupTest extends Baza {
  // для винды Windows users with Chocolatey installed: choco install chromedriver. Потом не понимаем, что этой винде ещё надо, психуем и укладываем драйверы в ресурсы. (./src/test/resources/)

  @Test
  public void adGroup() throws IOException {
    Konfig konf = new Konfig();
    goToGroup();
    initGroup();
    fillingGroup(konf);
    submitGroup();
    returnToGroupPage();
  }

}

