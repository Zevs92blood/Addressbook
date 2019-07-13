package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;

public class ChangeGroupTest extends Baza {
    @Test
    public void testChangeGroup() throws Exception {
        Konfig konf = new Konfig();
        app.getHelperOfNavigation().goToGroup();
        if (! app.getHelperOfGroup().seartchG()){

            app.getHelperOfGroup().createG(konf);
        }
        app.getHelperOfGroup().pinFirstAvailable();
        app.getHelperOfGroup().editGroup();
        app.getHelperOfGroup().fillingGroup(konf);
        app.getHelperOfGroup().updateGroup();
        app.getHelperOfGroup().returnToGroupPage();
    }
}
