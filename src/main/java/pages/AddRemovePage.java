package pages;

import base.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Страница "Add/Remove Elements".
 * Использует элементы типа Button для взаимодействия.
 */
public class AddRemovePage extends BasePage {

    // Кнопка "Add Element"
    private final Button addElementButton;

    public AddRemovePage(WebDriver driver) {
        super(driver, "elements");
        this.addElementButton = Button.byXPath(driver, "/html/body/div[2]/div/div/button");
    }

    /** Нажимает на кнопку "Add Element" */
    public void clickAddElement() {
        addElementButton.click();
    }

    /** Возвращает список всех текущих кнопок "Delete" */
    public List<WebElement> getDeleteButtons() {
        WebElement container = driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));
        return container.findElements(By.tagName("button"));
    }

    /** Возвращает количество кнопок "Delete" */
    public int getDeleteButtonsCount() {
        return getDeleteButtons().size();
    }

    /** Удаляет все элементы, поочерёдно кликая по каждой кнопке "Delete" */
    public void deleteAllElements() {
        for (WebElement element : getDeleteButtons()) {
            element.click();
        }
    }

    /** Проверяет наличие хотя бы одной кнопки "Delete" */
    public boolean hasDeleteButtons() {
        return getDeleteButtonsCount() > 0;
    }
}
