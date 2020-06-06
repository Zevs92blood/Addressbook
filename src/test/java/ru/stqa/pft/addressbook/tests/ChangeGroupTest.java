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
        if (app.getHelperOfGroup().getGroupList().size() == 0){

            app.getHelperOfGroup().createG(konf);
        }
        List<GData> ranee = app.getHelperOfGroup().getGroupList();
        int index = ranee.size() / 2;
        GData group = new GData(konf.groupName, ranee.get(index).getId());
        app.getHelperOfGroup().pinSeredinaAvailable(index);
        app.getHelperOfGroup().editGroup();
        app.getHelperOfGroup().fillingGroup(konf);
        app.getHelperOfGroup().updateGroup();
        app.getHelperOfGroup().returnToGroupPage();
        List<GData> potom = app.getHelperOfGroup().getGroupList();
        Assert.assertEquals(potom.size(), ranee.size());
        ranee.remove(index);
        ranee.add(group);

        proverkaNaCelostnostVsegoOstalnogoG(ranee, potom);

    }
}
