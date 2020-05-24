package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.GData;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.util.List;

public class DelGroupTest extends Baza {

    @Test
    public void testDelGroup() throws Exception {
        app.getHelperOfNavigation().goToGroup();
        if (! app.getHelperOfGroup().seartchG()){
            Konfig konf = new Konfig();
            app.getHelperOfGroup().createG(konf);
        }
        List<GData> ranee = app.getHelperOfGroup().getGroupList();
        app.getHelperOfGroup().pinSeredinaAvailable(ranee.size() / 2);
        app.getHelperOfGroup().deleteGroup();
        app.getHelperOfGroup().returnToGroupPage();
        List<GData> potom = app.getHelperOfGroup().getGroupList();
        Assert.assertEquals(potom.size(), ranee.size() - 1);

        ranee.remove(ranee.size() / 2);
        proverkaNaCelostnostVsegoOstalnogoG(ranee, potom);
    }


}