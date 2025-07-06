package pages;

import elements.Image;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Страница с изображениями, некоторые из которых могут быть сломанными.
 */
public class BrokenImagesPage extends BasePage {

    private final By imagesLocator = By.tagName("img");

    public BrokenImagesPage(WebDriver driver) {
        super(driver, "/html/body/div[2]/div/div");
    }

    /**
     * Возвращает все изображения на странице в виде списка объектов Image.
     * Использует индексы, так как Image работает по порядку элементов в XPath.
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
     * Проверяет, есть ли хотя бы одно сломанное изображение.
     *
     * @return true — если хотя бы одно изображение не загружено
     */
    public boolean anyImageBroken() {
        return getAllImages().stream().anyMatch(Image::isBroken);
    }
}
