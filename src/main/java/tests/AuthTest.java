package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AuthPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тест базовой аутентификации (basic auth).
 */
public class AuthTest extends BaseTest {

    @Test
    public void testBasicAuth() {
        // Открываем URL с базовой аутентификацией
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        AuthPage page = new AuthPage(driver);

        // Проверяем, что после авторизации отображается ожидаемое сообщение
        String expected = "Congratulations! You must have the proper credentials.";
        assertEquals(expected, page.getMessage(), "Сообщение после авторизации не соответствует ожидаемому");
    }
}
