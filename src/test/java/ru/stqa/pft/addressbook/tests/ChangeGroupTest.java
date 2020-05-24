package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.GData;
import ru.stqa.pft.addressbook.tech.Konfig;

import java.util.List;

public class ChangeGroupTest extends Baza {
    @Test
    public void testChangeGroup() throws Exception {
        Konfig konf = new Konfig();
        app.getHelperOfNavigation().goToGroup();
        if (! app.getHelperOfGroup().seartchG()){

            app.getHelperOfGroup().createG(konf);
        }
        List<GData> ranee = app.getHelperOfGroup().getGroupList();
        app.getHelperOfGroup().pinSeredinaAvailable(ranee.size() / 2);
        app.getHelperOfGroup().editGroup();
        app.getHelperOfGroup().fillingGroup(konf);
        GData group = new GData(konf.groupName, ranee.get(ranee.size() / 2).getId());
        app.getHelperOfGroup().updateGroup();
        app.getHelperOfGroup().returnToGroupPage();
        List<GData> potom = app.getHelperOfGroup().getGroupList();
        Assert.assertEquals(potom.size(), ranee.size());
        ranee.remove(ranee.size() / 2);
        ranee.add(group);

        proverkaNaCelostnostVsegoOstalnogoG(ranee, potom);

    }
}
