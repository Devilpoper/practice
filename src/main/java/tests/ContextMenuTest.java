package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;

public class ContextMenuTest extends BaseTest {

    @Test
    public void testContextMenuAlertAppearsCorrectly() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        ContextMenuPage page = new ContextMenuPage(driver);

        page.rightClickOnHotspot();

        String alertText = page.getAlertText();
        Assertions.assertEquals("You selected a context menu", alertText, "Некорректный текст alert");

        page.closeAlert();
    }
}
