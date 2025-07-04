package pages;

import base.BasePage;
import elements.Dropdown;
import org.openqa.selenium.WebDriver;

/**
 * Страница с выпадающим списком (dropdown).
 */
public class DropdownPage extends BasePage {

    // Объект Dropdown представляет элемент <select> со списком опций
    private final Dropdown dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver, "dropdown");
        this.dropdown = new Dropdown(driver);
    }

    /**
     * Выбирает опцию по видимому тексту.
     */
    public void selectOption(String visibleText) {
        dropdown.selectByVisibleText(visibleText);
    }

    /**
     * Возвращает текст выбранной опции.
     */
    public String getSelectedOption() {
        return dropdown.getSelectedOptionText();
    }

    /**
     * Проверяет, отображается ли опция с указанным значением.
     */
    public boolean isOptionDisplayed(String value) {
        return dropdown.isOptionDisplayed(value);
    }
}
