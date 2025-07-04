package pages;

import base.BasePage;
import elements.DownloadLink;
import org.openqa.selenium.WebDriver;

public class DownloadPage extends BasePage {

    public DownloadPage(WebDriver driver) {
        super(driver, "download");
    }

    public DownloadLink getDownloadLink(String fileName) {
        return new DownloadLink(driver, fileName);
    }
}
