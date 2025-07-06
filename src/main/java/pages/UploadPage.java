package pages;

import elements.Button;
import elements.Input;
import elements.Label;
import org.openqa.selenium.WebDriver;

/**
 * Страница загрузки файлов.
 */
public class UploadPage extends BasePage {

    public UploadPage(WebDriver driver) {
        super(driver, "upload");
    }

    /**
     * Поле ввода пути к файлу для загрузки.
     * Элемент <input type="file">.
     */
    public Input fileInput() {
        return new Input(driver, "//form//input[@type='file']", "");
    }

    /**
     * Кнопка загрузки файла.
     * Элемент <input type="submit">.
     */
    public Button uploadButton() {
        return new Button(driver, "//form//input[@type='submit']", "");
    }

    /**
     * Заголовок "File Uploaded!" после успешной загрузки.
     */
    public Label successMessage() {
        return new Label(driver, "//div[@class='example']/h3", "");
    }

    /**
     * Имя загруженного файла, отображающееся на странице.
     */
    public Label uploadedFileName() {
        return new Label(driver, "//div[@id='uploaded-files']", "");
    }
}
