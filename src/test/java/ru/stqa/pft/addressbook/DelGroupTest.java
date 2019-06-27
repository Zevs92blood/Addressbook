package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class DelGroupTest extends Baza {

    @Test
    public void testDelGroup() throws Exception {
        goToGroup();
        deleteGroup();
        returnToGroupPage();
    }

}