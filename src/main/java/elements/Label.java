package elements;

import base.BaseElement;
import org.openqa.selenium.WebDriver;

public class Label extends BaseElement {

    private static final String TEXT_XPATH = "//p[contains(text(),'%s')]";
    private static final String EXACT_TEXT_XPATH = "//p[normalize-space()='%s']";

    public Label(WebDriver driver, String xpathTemplate, String value) {
        super(driver, xpathTemplate, value);
    }

    public String getText() {
        return driver.findElement(locator).getText();
    }

    public static Label byExactText(WebDriver driver, String exactText) {
        return new Label(driver, EXACT_TEXT_XPATH, exactText);
    }

    public static Label byPartialText(WebDriver driver, String partialText) {
        return new Label(driver, TEXT_XPATH, partialText);
    }

    public static Label byXPath(WebDriver driver, String xpath) {
        return new Label(driver, "%s", xpath);
    }
}
