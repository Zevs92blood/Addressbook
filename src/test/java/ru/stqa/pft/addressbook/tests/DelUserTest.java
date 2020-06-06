package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.UData;
import ru.stqa.pft.addressbook.tech.Konfig;


import java.util.List;

public class DelUserTest extends Baza {
    @Test
    public void testDelUser() throws Exception {
        if (app.getHelperOfUser().getUserList().size() == 0) {
            Konfig konf = new Konfig();
            app.getHelperOfUser().createU(konf);

        }
        List<UData> ranee = app.getHelperOfUser().getUserList();
        app.getHelperOfUser().pinSeredinaAvailable(ranee.size() / 2);
        app.getHelperOfUser().pushDelButton();
        app.getHelperOfUser().acceptButtonOfAlert();
        app.getHelperOfNavigation().goToHome();
        List<UData> potom = app.getHelperOfUser().getUserList();
        Assert.assertEquals(potom.size(), ranee.size() - 1);

        ranee.remove(ranee.size() / 2);
        proverkaNaCelostnostVsegoOstalnogoU(ranee, potom);
    }
}
