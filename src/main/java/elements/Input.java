package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Класс для работы с полями ввода (input).
 * Позволяет вводить текст, получать текущее значение и отправлять путь к файлу.
 */
public class Input extends BaseElement {

    /**
     * Конструктор поля ввода.
     *
     * @param driver          экземпляр WebDriver
     * @param xpathTemplate   шаблон XPath
     * @param attributeValue  значение, подставляемое в шаблон
     */
    public Input(WebDriver driver, String xpathTemplate, String attributeValue) {
        super(driver, xpathTemplate, attributeValue);
    }

    /**
     * Ввод текста в поле.
     * Предварительно очищает поле.
     *
     * @param text текст для ввода
     */
    public void type(String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Получает текущее значение поля ввода.
     *
     * @return строка, содержащая значение атрибута "value"
     */
    public String getValue() {
        return driver.findElement(locator).getAttribute("value");
    }

    /**
     * Отправляет путь к файлу в поле (обычно используется для input type="file").
     *
     * @param filePath абсолютный путь к файлу
     */
    public void sendKeys(String filePath) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(filePath);
    }
}
