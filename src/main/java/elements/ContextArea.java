package elements;

import base.BaseElement;
import org.openqa.selenium.WebDriver;

/**
 * Класс для работы с контекстной областью на странице.
 * Используется, например, для тестирования правого клика.
 */
public class ContextArea extends BaseElement {
    public static final String HOTSPOT_XPATH = "/html/body/div[2]/div/div/div";

    /**
     * Конструктор контекстной области с фиксированным XPath.
     *
     * @param driver экземпляр WebDriver
     */
    public ContextArea(WebDriver driver) {
        super(driver, "%s", HOTSPOT_XPATH);
    }
}
