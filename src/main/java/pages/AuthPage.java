package pages;

import base.BasePage;
import elements.Label;
import org.openqa.selenium.WebDriver;

/**
 * Страница успешной авторизации.
 * Проверяет наличие поздравительного сообщения.
 */
public class AuthPage extends BasePage {

    private final Label successMessage;
    private static final String UNIQUE_TEXT = "Congratulations!";

    public AuthPage(WebDriver driver) {
        super(driver, "/html/body/div[2]/div/div/p");
        this.successMessage = Label.byPartialText(driver, UNIQUE_TEXT);
    }

    /** Получает текст сообщения об успешной авторизации */
    public String getMessage() {
        return successMessage.getText();
    }
}
