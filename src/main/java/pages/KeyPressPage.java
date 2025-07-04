package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyPressPage extends BasePage {
    private final Actions actions;
    private final By resultText = By.xpath("/html/body/div[2]/div/div/p[2]");

    public KeyPressPage(WebDriver driver) {
        super(driver, "elements");
        this.actions = new Actions(driver);
    }

    public void pressKey(CharSequence key) {
        actions.sendKeys(key).perform();
    }

    public String getDisplayedText() {
        WebElement resultElement = driver.findElement(resultText);
        return resultElement.getText();
    }
}
