package elements;

import base.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input extends BaseElement {

    public Input(WebDriver driver, String xpathTemplate, String attributeValue) {
        super(driver, xpathTemplate, attributeValue);
    }

    public void type(String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public String getValue() {
        return driver.findElement(locator).getAttribute("value");
    }

    public void sendKeys(String filePath) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(filePath);
    }
}



