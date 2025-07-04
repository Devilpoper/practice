package pages;

import base.BasePage;
import elements.Input;
import org.openqa.selenium.WebDriver;

public class InputsPage extends BasePage {
    public final Input numberInput;

    public InputsPage(WebDriver driver) {
        super(driver, "");
        this.numberInput = new Input(driver, "/html/body/div[2]/div/div/div/div/input", "");
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/inputs");
    }
}
