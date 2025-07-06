package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.time.Duration;

/**
 * Базовый класс для всех страниц приложения.
 * Инкапсулирует общую функциональность работы со страницами.
 */
public abstract class BasePage {
    private static final int WAIT_SECONDS = 10;
    private static final String BASE_ELEMENT_XPATH = "//div[contains(@name,'%s')]";

    protected final WebDriver driver;
    private final By baseLocator;

    /**
     * Конструктор базовой страницы.
     *
     * @param driver                    экземпляр WebDriver
     * @param uniqueElementIdentifier   уникальный идентификатор элемента страницы
     */
    protected BasePage(WebDriver driver, String uniqueElementIdentifier) {
        this.driver = driver;
        this.baseLocator = By.xpath(String.format(BASE_ELEMENT_XPATH, uniqueElementIdentifier));
    }

    /**
     * Проверяет, что страница загружена.
     *
     * @return true если базовый элемент страницы видим, иначе false
     */
    public boolean isLoaded() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS));
            WebElement baseElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(baseLocator)
            );
            return baseElement.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Обновляет текущую страницу и возвращает новый объект-страницу.
     *
     * @param pageClass класс страницы, которую нужно получить
     * @param <T>       тип страницы
     * @return новый экземпляр страницы
     */
    public <T extends BasePage> T refresh(Class<T> pageClass) {
        driver.navigate().refresh();
        return createPage(pageClass);
    }

    /**
     * Создаёт экземпляр страницы указанного класса.
     * <p>
     * Предполагается, что в классе-странице есть конструктор (WebDriver).
     *
     * @param pageClass класс страницы
     * @param <T>       тип страницы
     * @return новый экземпляр страницы
     */
    public <T extends BasePage> T createPage(Class<T> pageClass) {
        try {
            Constructor<T> ctor = pageClass.getDeclaredConstructor(WebDriver.class);
            return ctor.newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to create page instance for " + pageClass.getSimpleName(), e
            );
        }
    }
}
