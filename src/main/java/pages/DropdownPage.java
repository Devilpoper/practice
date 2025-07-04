package pages;

import base.BasePage;
import elements.Dropdown;
import org.openqa.selenium.WebDriver;

public class DropdownPage extends BasePage {
    private final Dropdown dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver, "dropdown");
        this.dropdown = new Dropdown(driver);
    }

    public void selectOption(String visibleText) {
        dropdown.selectByVisibleText(visibleText);
    }

    public String getSelectedOption() {
        return dropdown.getSelectedOptionText();
    }

    public boolean isOptionDisplayed(String value) {
        return dropdown.isOptionDisplayed(value);
    }
}
