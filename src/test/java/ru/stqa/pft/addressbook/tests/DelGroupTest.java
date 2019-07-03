package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DelGroupTest extends Baza {

    @Test
    public void testDelGroup() throws Exception {
        app.getHelperOfNavigation().goToGroup();
        app.getHelperOfGroup().deleteGroup();
        app.getHelperOfGroup().returnToGroupPage();
    }

}