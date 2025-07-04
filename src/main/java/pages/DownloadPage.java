package pages;

import base.BasePage;
import elements.DownloadLink;
import org.openqa.selenium.WebDriver;

/**
 * Страница со ссылками для загрузки файлов.
 */
public class DownloadPage extends BasePage {

    public DownloadPage(WebDriver driver) {
        super(driver, "download");
    }

    /**
     * Получает ссылку на файл по его имени.
     *
     * @param fileName имя файла, как указано в href
     * @return объект DownloadLink для взаимодействия
     */
    public DownloadLink getDownloadLink(String fileName) {
        return new DownloadLink(driver, fileName);
    }
}
