/**
 * Класс для работы со ссылками на скачивание файлов.
 */
public class DownloadLink extends BaseElement {

    /**
     * Конструктор ссылки на скачивание по части имени файла.
     *
     * @param driver   экземпляр WebDriver
     * @param fileName часть имени файла в href
     */
    public DownloadLink(WebDriver driver, String fileName) {
        super(driver, "//a[contains(@href,'%s')]", fileName);
    }

    /**
     * Кликает по ссылке на скачивание.
     */
    public void click() {
        driver.findElement(locator).click();
    }
}
