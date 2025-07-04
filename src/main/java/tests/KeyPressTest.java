package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.KeyPressPage;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyPressTest extends BaseTest {

    @Test
    public void testKeyPresses() {
        driver.get("https://the-internet.herokuapp.com/key_presses");

        KeyPressPage keyPressPage = new KeyPressPage(driver);

        keyPressPage.pressKey("g");
        assertEquals("You entered: G", keyPressPage.getDisplayedText(), "Клавиша G не отображается корректно");

        keyPressPage.pressKey(Keys.ENTER);
        assertEquals("You entered: ENTER", keyPressPage.getDisplayedText(), "Клавиша ENTER не отображается корректно");
    }
}
