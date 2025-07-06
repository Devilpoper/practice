package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HoversPage;

/**
 * Проверка, что при наведении на аватар появляется имя пользователя.
 */
public class HoversTest extends BaseTest {

    @Test
    public void testHoverShowsUserName() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        HoversPage hoversPage = new HoversPage(driver);

        // Наводим курсор на аватар
        hoversPage.hoverOnAvatar();

        // Проверяем, что появившийся текст соответствует имени пользователя
        String expected = "name: user1";
        String actual = hoversPage.getUserNameText();
        Assertions.assertEquals(expected, actual, "Имя пользователя не совпадает");
    }
}
