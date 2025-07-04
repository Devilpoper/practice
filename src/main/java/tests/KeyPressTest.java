package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.KeyPressPage;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Проверяет корректное отображение текста при нажатии различных клавиш.
 */
public class KeyPressTest extends BaseTest {

    /**
     * Проверяет отображение текста для обычной клавиши и клавиши Enter.
     */
    @Test
    public void testKeyPresses() {
        // Открываем страницу с обработкой нажатий клавиш
        driver.get("https://the-internet.herokuapp.com/key_presses");

        KeyPressPage keyPressPage = new KeyPressPage(driver);

        // Нажимаем клавишу "g" и проверяем отображение результата
        keyPressPage.pressKey("g");
        assertEquals("You entered: G", keyPressPage.getDisplayedText(), "Клавиша G не отображается корректно");

        // Нажимаем клавишу ENTER и проверяем отображение результата
        keyPressPage.pressKey(Keys.ENTER);
        assertEquals("You entered: ENTER", keyPressPage.getDisplayedText(), "Клавиша ENTER не отображается корректно");
    }
}
