/**
 * Класс для работы с контекстной областью (например, зона для правого клика).
 */
public class ContextArea extends BaseElement {
    public static final String HOTSPOT_XPATH = "/html/body/div[2]/div/div/div";

    /**
     * Конструктор элемента контекстной области.
     *
     * @param driver экземпляр WebDriver
     */
    public ContextArea(WebDriver driver) {
        super(driver, "%s", HOTSPOT_XPATH);
    }
}
