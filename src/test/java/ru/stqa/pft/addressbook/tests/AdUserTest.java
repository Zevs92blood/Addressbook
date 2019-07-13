package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;

public class AdUserTest extends Baza {


  @Test
  public void testAdUser() throws Exception {
    Konfig konf = new Konfig();
    app.getHelperOfUser().initUser();
    app.getHelperOfUser().writeUserData(konf, true);
    app.getHelperOfUser().createUser();
  }


}
