package pages;

import base.BasePage;
import elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Страница "Add/Remove Elements" без прямых By:
 * все действия через класс Button.
 */
public class AddRemovePage extends BasePage {

    private final Button addElementButton;


    public AddRemovePage(WebDriver driver) {
        // В качестве уникального признака страницы можно взять, например, текст кнопки
        super(driver, "elements");
        this.addElementButton = Button.byXPath(driver, "/html/body/div[2]/div/div/button");

    }

    /** Функция нажатия на кнопку */
    public void clickAddElement() {
        addElementButton.click();
    }

    public List<WebElement> getDeleteButtons(){
        WebElement container = driver.findElement(By.xpath("/html/body/div[2]/div/div/div"));
        return container.findElements(By.tagName("button"));
    }

    /** Возвращает текущее число кнопок Delete */
    public int getDeleteButtonsCount() {
        return getDeleteButtons().size();
    }

    /** Удаляет все кнопки Delete, кликая по первой из них до тех пор, пока они есть */
    public void deleteAllElements() {
        for (WebElement element : getDeleteButtons()) {
            element.click();
        }
    }

    /** Проверяет, что на странице есть хотя бы одна Delete-кнопка */
    public boolean hasDeleteButtons() {
        return getDeleteButtonsCount() > 0;
    }
}
