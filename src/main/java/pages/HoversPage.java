package pages;

import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Страница с аватарами, при наведении на которые отображаются подписи.
 */
public class HoversPage extends BasePage {

    // Элемент изображения аватара, на который нужно навести курсор
    private final WebElement avatarIcon;

    private static final String UNIQUE_IDENTIFIER = "hovers";

    public HoversPage(WebDriver driver) {
        super(driver, UNIQUE_IDENTIFIER);

        // Ищем первый аватар по XPath
        avatarIcon = driver.findElement(
                By.xpath("/html/body/div[2]/div/div/div[1]/img"));
    }

    /**
     * Наводит курсор на аватар для отображения текста.
     */
    public void hoverOnAvatar() {
        Actions actions = new Actions(driver);
        actions.moveToElement(avatarIcon).perform();
    }

    /**
     * Получает имя пользователя, появляющееся после наведения.
     */
    public String getUserNameText() {
        // Label — элемент для работы с текстовыми элементами <p>, <h5> и т.п.
        Label userInfo = new Label(driver, "(//div[@class='figure'])[1]//h5", "");
        return userInfo.getText();
    }
}
