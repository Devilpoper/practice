package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HoversPage;

public class HoversTest extends BaseTest {

    @Test
    public void testHoverShowsUserName() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        HoversPage hoversPage = new HoversPage(driver);
        
        hoversPage.hoverOnAvatar();

        String expected = "name: user1";
        String actual = hoversPage.getUserNameText();

        Assertions.assertEquals(expected, actual, "Имя пользователя не совпадает");
    }
}
