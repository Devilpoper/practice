package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Страница для проверки ввода с клавиатуры.
 */
public class KeyPressPage extends BasePage {

    // Используем Actions для отправки нажатий клавиш
    private final Actions actions;

    // Локатор результата отображаемого текста
    private final By resultText = By.xpath("/html/body/div[2]/div/div/p[2]");

    public KeyPressPage(WebDriver driver) {
        super(driver, "elements");
        this.actions = new Actions(driver);
    }

    /**
     * Отправляет нажатие клавиши на страницу.
     */
    public void pressKey(CharSequence key) {
        actions.sendKeys(key).perform();
    }

    /**
     * Получает текст, который появился после нажатия клавиши.
     */
    public String getDisplayedText() {
        WebElement resultElement = driver.findElement(resultText);
        return resultElement.getText();
    }
}
