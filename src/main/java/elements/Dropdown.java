package elements;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Класс для работы с выпадающим списком (элемент <select>).
 */
public class Dropdown extends BaseElement {
    private final Select select;

    /**
     * Конструктор dropdown с фиксированным XPath.
     * Инициализирует объект Select на найденном элементе.
     *
     * @param driver экземпляр WebDriver
     */
    public Dropdown(WebDriver driver) {
        super(driver, "%s", "/html/body/div[2]/div/div/select");
        WebElement element = driver.findElement(this.locator);
        this.select = new Select(element);
    }

    /**
     * Выбирает опцию по видимому тексту.
     *
     * @param text текст опции
     */
    public void selectByVisibleText(String text) {
        select.selectByVisibleText(text);
    }

    /**
     * Возвращает текст текущей выбранной опции.
     *
     * @return текст выбранного значения
     */
    public String getSelectedOptionText() {
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Проверяет, отображается ли опция с заданным значением.
     *
     * @param value значение атрибута value
     * @return true если элемент найден и отображается, иначе false
     */
    public boolean isOptionDisplayed(String value) {
        return driver.findElement(By.xpath("//option[@value='" + value + "']")).isDisplayed();
    }
}
