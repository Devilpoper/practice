package elements;

import base.BaseElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс для работы с изображениями <img>.
 */
public class Image extends BaseElement {

    private static final String INDEXED_IMAGE_XPATH = "(//img)[%s]";

    /**
     * Конструктор принимает индекс изображения на странице.
     * Индексация XPath начинается с 1.
     */
    public Image(WebDriver driver, int index) {
        super(driver, INDEXED_IMAGE_XPATH, String.valueOf(index));
    }

    /**
     * Проверяет, сломано ли изображение (naturalWidth === 0 || naturalHeight === 0).
     */
    public boolean isBroken() {
        try {
            WebElement img = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (Boolean) js.executeScript(
                    "return arguments[0].naturalWidth === 0 || arguments[0].naturalHeight === 0",
                    img);
        } catch (Exception e) {
            return true; // Если элемент не найден или ошибка, считаем изображение сломанным
        }
    }
}
