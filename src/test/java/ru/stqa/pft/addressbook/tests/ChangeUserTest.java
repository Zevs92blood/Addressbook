package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.GData;
import ru.stqa.pft.addressbook.tech.Konfig;
import ru.stqa.pft.addressbook.tech.UData;

import java.util.List;


public class ChangeUserTest extends Baza {
    @Test
    public void testChangeUser() throws Exception {
        Konfig konf = new Konfig();
        if (app.getHelperOfUser().getUserList().size() == 0) {
            app.getHelperOfUser().createU(konf);

        }
        List<UData> ranee = app.getHelperOfUser().getUserList();
        //app.getHelperOfUser().pinSeredinaAvailable(ranee.size() / 2);
        app.getHelperOfUser().pushEditButton(ranee.size() / 2);
        app.getHelperOfUser().writeUserData(konf, false);
        UData user = new UData(konf.first_name, konf.last_name, ranee.get(ranee.size() / 2).getId());
        app.getHelperOfUser().updateUser();
        app.getHelperOfNavigation().goToHome();
        List<UData> potom = app.getHelperOfUser().getUserList();
        Assert.assertEquals(potom.size(), ranee.size());
        ranee.remove(ranee.size() / 2);
        ranee.add(user);
        proverkaNaCelostnostVsegoOstalnogoU(ranee, potom);
    }
}
