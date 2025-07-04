package pages;

import base.BasePage;
import base.BaseElement;
import elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage extends BasePage {

    private final WebElement avatarIcon;

    private static final String UNIQUE_IDENTIFIER = "hovers"; // например, часть xpath уникального элемента страницы

    public HoversPage(WebDriver driver) {
        super(driver, UNIQUE_IDENTIFIER);
        // Локатор для иконки первого аватара (с учётом контекста страницы)
        avatarIcon = driver.findElement(
                By.xpath("/html/body/div[2]/div/div/div[1]/img"));
    }

    /**
     * Наводит курсор на иконку аватара.
     */
    public void hoverOnAvatar() {
        Actions actions = new Actions(driver);
        actions.moveToElement(avatarIcon).perform();
    }

    /**
     * Возвращает текст имени пользователя, который появляется при наведении.
     */
    public String getUserNameText() {
        Label userInfo = new Label(driver, "(//div[@class='figure'])[1]//h5", "");
        return userInfo.getText();
    }
}
