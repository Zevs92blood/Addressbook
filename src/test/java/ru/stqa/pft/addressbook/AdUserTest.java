package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AdUserTest extends Baza {


  @Test
  public void testAdUser() throws Exception {
    Konfig konf = new Konfig();
    initUser();
    writeUserData(konf);
    createUser();
  }


}
