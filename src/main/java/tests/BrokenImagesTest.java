package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;

/**
 * Проверка наличия сломанных изображений на странице.
 */
public class BrokenImagesTest extends BaseTest {

    @Test
    public void testBrokenImagesPresent() {
        driver.get("https://the-internet.herokuapp.com/broken_images");

        BrokenImagesPage page = new BrokenImagesPage(driver);

        // Проверяем, что хотя бы одно изображение сломано
        Assertions.assertTrue(page.anyImageBroken(), "Сломанные изображения не обнаружены");
    }
}
