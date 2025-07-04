package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.AuthPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тест авторизации по базовой аутентификации (basic auth).
 */
public class AuthTest extends BaseTest {

    @Test
    public void testBasicAuth() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        AuthPage page = new AuthPage(driver);

        String expected = "Congratulations! You must have the proper credentials.";
        assertEquals(expected, page.getMessage(), "Сообщение после авторизации не соответствует ожидаемому");
    }
}
