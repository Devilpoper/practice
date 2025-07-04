package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;

/**
 * Проверка, что на странице есть хотя бы одно сломанное изображение.
 */
public class BrokenImagesTest extends BaseTest {

    @Test
    public void testBrokenImagesPresent() {
        driver.get("https://the-internet.herokuapp.com/broken_images");

        BrokenImagesPage page = new BrokenImagesPage(driver);

        // Утверждаем, что среди изображений есть сломанные
        Assertions.assertTrue(page.anyImageBroken(), "Сломанные изображения не обнаружены");
    }
}
