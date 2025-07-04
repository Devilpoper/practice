package pages;

import base.BasePage;
import elements.Button;
import elements.Input;
import elements.Label;
import org.openqa.selenium.WebDriver;

public class UploadPage extends BasePage {

    public UploadPage(WebDriver driver) {
        super(driver, "upload");
    }

    public Input fileInput() {
        return new Input(driver, "//form//input[@type='file']", "");
    }

    public Button uploadButton() {
        return new Button(driver, "//form//input[@type='submit']", "");
    }

    public Label successMessage() {
        return new Label(driver, "//div[@class='example']/h3", "");
    }

    public Label uploadedFileName() {
        return new Label(driver, "//div[@id='uploaded-files']", "");
    }
}
