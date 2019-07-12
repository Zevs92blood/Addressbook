package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DelUserTest extends Baza{
    @Test
    public void testDelUser() throws Exception {
    app.getHelperOfUser().pinFirstAvailable();
    app.getHelperOfUser().pushDelButton();
    app.getHelperOfUser().acceptButtonOfAlert();
    }
}
