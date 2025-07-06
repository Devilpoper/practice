package elements;

import org.openqa.selenium.WebDriver;

/**
 * Класс для работы со ссылками на загрузку файлов.
 */
public class DownloadLink extends BaseElement {

    /**
     * Конструктор, принимающий часть имени файла.
     * Используется для поиска ссылки на скачивание по href.
     *
     * @param driver   экземпляр WebDriver
     * @param fileName часть пути в href
     */
    public DownloadLink(WebDriver driver, String fileName) {
        super(driver, "//a[contains(@href,'%s')]", fileName);
    }

    /**
     * Кликает по ссылке на скачивание файла.
     */
    public void click() {
        driver.findElement(locator).click();
    }
}
