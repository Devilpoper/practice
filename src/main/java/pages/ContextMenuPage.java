package pages;

import base.BasePage;
import elements.ContextArea;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    private final ContextArea contextArea;

    public ContextMenuPage(WebDriver driver) {
        super(driver, "context_menu");
        this.contextArea = new ContextArea(driver);
    }

    public void rightClickOnHotspot() {
        new Actions(driver)
                .contextClick(driver.findElement(By.xpath(contextArea.HOTSPOT_XPATH)))
                .perform();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void closeAlert() {
        driver.switchTo().alert().accept();
    }
}
