package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.InputsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputsTest extends BaseTest {

    @Test
    public void testNumberInputIgnoresNonNumericCharacters() {
        InputsPage page = new InputsPage(driver);
        page.open();

        // Ввод значения с символом
        page.numberInput.type("55f");

        // Проверка, что осталась только цифра
        String actual = page.numberInput.getValue();
        assertEquals("55", actual, "Поле должно содержать только число 55");
    }
}
