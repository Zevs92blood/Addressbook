package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;
import ru.stqa.pft.addressbook.tech.UData;

import java.util.List;

public class AdUserTest extends Baza {


  @Test
  public void testAdUser() throws Exception {
    Konfig konf = new Konfig();
    List<UData> ranee = app.getHelperOfUser().getUserList();
    app.getHelperOfUser().initUser();

    app.getHelperOfUser().writeUserData(konf, true);
    UData user = new UData(konf.first_name, konf.last_name);
    app.getHelperOfUser().createUser();
    app.getHelperOfUser().backToHP();
    List<UData> potom = app.getHelperOfUser().getUserList();

    ranee.add(user);
    proverkaNaCelostnostVsegoOstalnogoU(ranee, potom);

  }


}
