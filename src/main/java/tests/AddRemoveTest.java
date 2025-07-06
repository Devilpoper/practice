package tests;

import org.junit.jupiter.api.Test;
import pages.AddRemovePage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * UI-тесты страницы Add/Remove Elements.
 */
public class AddRemoveTest extends BaseTest {

    @Test
    public void testAddAndRemoveElements() {
        // Переход на нужную страницу
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Инициализация страницы
        AddRemovePage page = new AddRemovePage(driver);

        // Добавляем 2 элемента
        page.clickAddElement();
        page.clickAddElement();

        // Проверяем, что добавлены 2 delete-кнопки
        int countAfterAdd = page.getDeleteButtonsCount();
        System.out.println("Добавлено: " + countAfterAdd);
        assertEquals(2, countAfterAdd, "Ожидалось 2 delete-кнопки после добавления");

        // Удаляем все элементы
        page.deleteAllElements();

        // Проверяем, что все удалены
        int countAfterDelete = page.getDeleteButtonsCount();
        System.out.println("Осталось после удаления: " + countAfterDelete);
        assertEquals(0, countAfterDelete, "Ожидалось 0 delete-кнопок после удаления");
        assertFalse(page.hasDeleteButtons(), "Delete-кнопки должны отсутствовать");
    }
}
