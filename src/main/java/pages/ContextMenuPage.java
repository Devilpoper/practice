package pages;

import elements.ContextArea;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Страница с контекстным меню.
 * Реализует правый клик и работу с алертом.
 */
public class ContextMenuPage extends BasePage {

    private final ContextArea contextArea;

    public ContextMenuPage(WebDriver driver) {
        super(driver, "context_menu");
        this.contextArea = new ContextArea(driver);
    }

    /** Выполняет правый клик на выделенной области (hotspot) */
    public void rightClickOnHotspot() {
        new Actions(driver)
                .contextClick(driver.findElement(By.xpath(contextArea.HOTSPOT_XPATH)))
                .perform();
    }

    /** Получает текст всплывающего окна (alert) */
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    /** Закрывает alert (нажимает OK) */
    public void closeAlert() {
        driver.switchTo().alert().accept();
    }
}
