package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;

public class DelUserTest extends Baza{
    @Test
    public void testDelUser() throws Exception {
        if (! app.getHelperOfUser().seartchU()){
            Konfig konf = new Konfig();
            app.getHelperOfUser().createU(konf);

        }

    app.getHelperOfUser().pinFirstAvailable();
    app.getHelperOfUser().pushDelButton();
    app.getHelperOfUser().acceptButtonOfAlert();
    }
}
