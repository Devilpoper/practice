package elements;

import base.BaseElement;
import org.openqa.selenium.WebDriver;

public class DownloadLink extends BaseElement {

    public DownloadLink(WebDriver driver, String fileName) {
        super(driver, "//a[contains(@href,'%s')]", fileName);
    }

    public void click() {
        driver.findElement(locator).click();
    }
}
