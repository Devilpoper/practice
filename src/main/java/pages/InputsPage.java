package pages;

import elements.Input;
import org.openqa.selenium.WebDriver;

/**
 * Страница с числовым полем ввода.
 */
public class InputsPage extends BasePage {

    // Input — поле ввода. В данном случае используется для чисел.
    public final Input numberInput;

    public InputsPage(WebDriver driver) {
        super(driver, "");
        this.numberInput = new Input(driver, "/html/body/div[2]/div/div/div/div/input", "");
    }

    /**
     * Переход на URL страницы с вводом чисел.
     */
    public void open() {
        driver.get("https://the-internet.herokuapp.com/inputs");
    }
}
