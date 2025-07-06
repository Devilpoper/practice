package elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Базовый класс для всех элементов пользовательского интерфейса.
 * Инкапсулирует общую функциональность для работы с веб-элементами.
 */
public class BaseElement {
    protected static final int WAIT_SECONDS = 10;
    protected final WebDriver driver;
    protected final By locator;

    /**
     * Конструктор базового элемента.
     *
     * @param driver        экземпляр WebDriver
     * @param xpathTemplate шаблон XPath для поиска элемента
     * @param attributeValue параметр для подстановки в шаблон XPath
     */
    protected BaseElement(WebDriver driver, String xpathTemplate, String attributeValue) {
        this.driver = driver;
        this.locator = By.xpath(String.format(xpathTemplate, attributeValue));
    }

    /**
     * Проверяет, отображается ли элемент на странице.
     * Ожидает появление элемента в течение стандартного времени ожидания.
     *
     * @return true если элемент отображается, иначе false
     */
    public boolean isDisplayed() {
        return isDisplayed(WAIT_SECONDS);
    }

    /**
     * Проверяет, отображается ли элемент на странице с кастомным временем ожидания.
     *
     * @param seconds время ожидания в секундах
     * @return true если элемент отображается, иначе false
     */
    public boolean isDisplayed(int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Проверяет, доступен ли элемент для взаимодействия.
     *
     * @return true если элемент доступен, иначе false
     */
    public boolean isEnabled() {
        try {
            WebElement element = driver.findElement(locator);
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Возвращает значение указанного атрибута элемента.
     *
     * @param attributeName название атрибута
     * @return значение атрибута или null, если атрибут отсутствует
     */
    public String getAttribute(String attributeName) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getAttribute(attributeName);
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
