package pages;

import base.BasePage;
import elements.Image;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Страница с изображениями, в том числе сломанными.
 */
public class BrokenImagesPage extends BasePage {

    private final By imagesLocator = By.tagName("img");

    public BrokenImagesPage(WebDriver driver) {
        super(driver, "/html/body/div[2]/div/div");
    }

    /**
     * Получить список всех изображений на странице в виде объектов Image.
     */
    public List<Image> getAllImages() {
        List<WebElement> rawImages = driver.findElements(imagesLocator);
        List<Image> imageList = new ArrayList<>();

        for (int i = 1; i <= rawImages.size(); i++) {
            imageList.add(new Image(driver, i));
        }

        return imageList;
    }

    /**
     * Проверяет, есть ли среди изображений сломанные.
     */
    public boolean anyImageBroken() {
        return getAllImages().stream().anyMatch(Image::isBroken);
    }
}

