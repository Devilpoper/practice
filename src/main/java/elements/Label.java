package elements;

import org.openqa.selenium.WebDriver;

/**
 * Класс для работы с текстовыми элементами <p>.
 * Позволяет искать элементы по точному или частичному совпадению текста.
 */
public class Label extends BaseElement {

    // XPath для поиска элемента <p>, содержащего подстроку
    private static final String TEXT_XPATH = "//p[contains(text(),'%s')]";

    // XPath для поиска элемента <p> с точным совпадением текста (без лишних пробелов)
    private static final String EXACT_TEXT_XPATH = "//p[normalize-space()='%s']";

    /**
     * Конструктор текстовой метки.
     *
     * @param driver         экземпляр WebDriver
     * @param xpathTemplate  шаблон XPath
     * @param value          значение для подстановки в шаблон
     */
    public Label(WebDriver driver, String xpathTemplate, String value) {
        super(driver, xpathTemplate, value);
    }

    /**
     * Возвращает текст, содержащийся в метке.
     *
     * @return текст элемента <p>
     */
    public String getText() {
        return driver.findElement(locator).getText();
    }

    /**
     * Поиск метки по точному совпадению текста.
     *
     * @param driver     экземпляр WebDriver
     * @param exactText  точный текст
     * @return экземпляр Label
     */
    public static Label byExactText(WebDriver driver, String exactText) {
        return new Label(driver, EXACT_TEXT_XPATH, exactText);
    }

    /**
     * Поиск метки по частичному совпадению текста.
     *
     * @param driver       экземпляр WebDriver
     * @param partialText  часть текста
     * @return экземпляр Label
     */
    public static Label byPartialText(WebDriver driver, String partialText) {
        return new Label(driver, TEXT_XPATH, partialText);
    }

    /**
     * Поиск метки по произвольному XPath.
     *
     * @param driver экземпляр WebDriver
     * @param xpath  полный XPath
     * @return экземпляр Label
     */
    public static Label byXPath(WebDriver driver, String xpath) {
        return new Label(driver, "%s", xpath);
    }
}
