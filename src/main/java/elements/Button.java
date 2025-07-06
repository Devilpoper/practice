package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс для работы с элементами типа "кнопка".
 * Предоставляет методы для поиска кнопок по различным атрибутам
 * и выполнения действий над ними.
 */
public class Button extends BaseElement {
    private static final String ID_XPATH          = "//button[@id='%s']";
    private static final String TEXT_XPATH        = "//button[contains(text(),'%s')]";
    private static final String CLASS_XPATH       = "//button[@class='%s']";
    private static final String TYPE_XPATH        = "//button[@type='%s']";
    private static final String ARIA_LABEL_XPATH  = "//button[@aria-label='%s']";
    private static final int    WAIT_SECONDS      = 10;

    /**
     * публичный конструктор.
     *
     * @param driver   экземпляр WebDriver
     * @param xpathTpl шаблон XPath
     * @param param    параметр для подстановки в шаблон
     */
    public Button(WebDriver driver, String xpathTpl, String param) {
        super(driver, xpathTpl, param);
    }

    /**
     * Выполняет клик по кнопке, дождавшись её кликабельности.
     */
    public void click() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }

    public static Button byId(WebDriver driver, String id) {
        return new Button(driver, ID_XPATH, id);
    }

    public static Button byText(WebDriver driver, String text) {
        return new Button(driver, TEXT_XPATH, text);
    }

    public static Button byClass(WebDriver driver, String className) {
        return new Button(driver, CLASS_XPATH, className);
    }

    public static Button byType(WebDriver driver, String type) {
        return new Button(driver, TYPE_XPATH, type);
    }

    public static Button byAriaLabel(WebDriver driver, String ariaLabel) {
        return new Button(driver, ARIA_LABEL_XPATH, ariaLabel);
    }

    /**
     * Поиск по произвольному XPath.
     *
     * @param driver экземпляр WebDriver
     * @param xpath  полный XPath выражения
     * @return Button
     */
    public static Button byXPath(WebDriver driver, String xpath) {
        // передаём шаблон "%s" и сам xpath как параметр
        return new Button(driver, "%s", xpath);
    }
}
