package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tech.Konfig;
import ru.stqa.pft.addressbook.tech.UData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CorrectNumUserTest extends Baza {
    @Test
    public void testChangeUser() throws Exception {
        Konfig konf = new Konfig();
        if (app.getHelperOfUser().getUserList().size() == 0) {
            app.getHelperOfUser().createU(konf);

        }
        List<UData> spisok = app.getHelperOfUser().getUserList();
        String vTablichke = spisok.get(0).getTNum();

        app.getHelperOfUser().pushDetailsButton(0);
        List vDN = app.getHelperOfUser().getDetails();
        String result = (String) vDN.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("\n", "", ""));






        Assert.assertEquals(vTablichke, result);
    }
}
