package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AdUserTest extends Baza {


  @Test
  public void testAdUser() throws Exception {

    initUser();
    writeUserData();
    createUser();
  }


}
