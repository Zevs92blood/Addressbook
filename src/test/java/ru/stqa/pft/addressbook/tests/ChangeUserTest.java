package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;


public class ChangeUserTest extends Baza {
    @Test
    public void testChangeUser() throws Exception {
        Konfig konf = new Konfig();
        app.getHelperOfUser().pinFirstAvailable();
        app.getHelperOfUser().pushEditButton();
        app.getHelperOfUser().writeUserData(konf);
        app.getHelperOfUser().updateUser();
    }
}
