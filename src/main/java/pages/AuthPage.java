package pages;

import elements.Label;
import org.openqa.selenium.WebDriver;

/**
 * Страница успешной авторизации.
 * Проверяет наличие поздравительного сообщения.
 */
public class AuthPage extends BasePage {

    private final Label successMessage;
    private static final String UNIQUE_TEXT = "Congratulations!";
    private static final String xpath = "/html/body/div[2]/div/div/p";

    public AuthPage(WebDriver driver) {
        super(driver, xpath);
        this.successMessage = Label.byPartialText(driver, UNIQUE_TEXT);
    }

    /** Получает текст сообщения об успешной авторизации */
    public String getMessage() {
        return successMessage.getText();
    }
}
