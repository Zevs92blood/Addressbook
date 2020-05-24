package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;


public class ChangeUserTest extends Baza {
    @Test
    public void testChangeUser() throws Exception {
        Konfig konf = new Konfig();
        if (! app.getHelperOfUser().seartchU()) {
            app.getHelperOfUser().createU(konf);

        }
     //   app.getHelperOfUser().pinSeredinaAvailable();
        app.getHelperOfUser().pushEditButton();
        app.getHelperOfUser().writeUserData(konf, false);
        app.getHelperOfUser().updateUser();
    }
}
