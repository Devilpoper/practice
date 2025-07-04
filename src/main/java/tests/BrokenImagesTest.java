package tests;


import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.BrokenImagesPage;

public class BrokenImagesTest extends BaseTest {

    @Test
    public void testBrokenImagesPresent() {
        driver.get("https://the-internet.herokuapp.com/broken_images");

        BrokenImagesPage page = new BrokenImagesPage(driver);

        // Проверяем, что среди изображений есть хотя бы одно сломанное
        Assertions.assertTrue(page.anyImageBroken(), "Сломанные изображения не обнаружены");
    }
}

