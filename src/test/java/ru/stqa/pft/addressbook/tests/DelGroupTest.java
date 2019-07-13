package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;

public class DelGroupTest extends Baza {

    @Test
    public void testDelGroup() throws Exception {
        app.getHelperOfNavigation().goToGroup();
        if (! app.getHelperOfGroup().seartchG()){
            Konfig konf = new Konfig();
            app.getHelperOfGroup().createG(konf);
        }
        app.getHelperOfGroup().pinFirstAvailable();
        app.getHelperOfGroup().deleteGroup();
        app.getHelperOfGroup().returnToGroupPage();
    }

}