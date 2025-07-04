package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownSelection() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        DropdownPage page = new DropdownPage(driver);

        // Проверяем отображение опции
        Assertions.assertTrue(page.isOptionDisplayed("1"), "Option 1 не отображается");

        // Выбираем опцию
        page.selectOption("Option 1");

        // Проверяем выбранный текст
        Assertions.assertEquals("Option 1", page.getSelectedOption(), "Неверный выбранный элемент");
    }
}
