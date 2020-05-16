package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GoToPageGoToBack extends Baza {
    @Test
    public void testDelGroup() throws Exception {
        app.getHelperOfNavigation().goToGroup();

        app.getHelperOfNavigation().goToHome();
    }
}