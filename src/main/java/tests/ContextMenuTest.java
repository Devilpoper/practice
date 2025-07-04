package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ContextMenuPage;

/**
 * Тест проверки появления alert после клика правой кнопкой на hotspot.
 */
public class ContextMenuTest extends BaseTest {

    @Test
    public void testContextMenuAlertAppearsCorrectly() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        ContextMenuPage page = new ContextMenuPage(driver);

        // Выполняем правый клик на указанном элементе
        page.rightClickOnHotspot();

        // Проверяем текст alert
        String alertText = page.getAlertText();
        Assertions.assertEquals("You selected a context menu", alertText, "Некорректный текст alert");

        // Закрываем alert
        page.closeAlert();
    }
}
