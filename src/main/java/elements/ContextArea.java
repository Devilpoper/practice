package elements;

import base.BaseElement;
import org.openqa.selenium.WebDriver;

public class ContextArea extends BaseElement {
    public static final String HOTSPOT_XPATH = "/html/body/div[2]/div/div/div";

    public ContextArea(WebDriver driver) {
        super(driver, "%s", HOTSPOT_XPATH);
    }
}
