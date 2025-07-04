package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.InputsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputsTest extends BaseTest {

    /**
     * Вводим "55f" и ожидаем, что останется только "55".
     */
    @Test
    public void testNumberInputIgnoresNonNumericCharacters() {
        InputsPage page = new InputsPage(driver);
        page.open(); // Открываем страницу с полем ввода

        // Вводим строку с цифрами и символом
        page.numberInput.type("55f");

        // Получаем значение из поля и проверяем, что остались только цифры
        String actual = page.numberInput.getValue();
        assertEquals("55", actual, "Поле должно содержать только число 55");
    }
}
