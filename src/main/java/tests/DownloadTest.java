package tests;

import elements.DownloadLink;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DownloadPage;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тест скачивания файла с сайта и проверка успешной загрузки.
 */
public class DownloadTest {

    private WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com/";
    private static final String DOWNLOAD_DIR = System.getProperty("user.dir") + File.separator + "downloads";
    private static final String FILE_NAME = "Image.PNG";

    @BeforeEach
    public void setUp() {
        // Создаем папку для загрузок, если она не существует
        File downloadsFolder = new File(DOWNLOAD_DIR);
        if (!downloadsFolder.exists()) downloadsFolder.mkdir();

        // Удаляем старый файл, чтобы тест был чистым
        File oldFile = new File(DOWNLOAD_DIR + File.separator + FILE_NAME);
        if (oldFile.exists()) oldFile.delete();

        // Настраиваем ChromeOptions для автоматической загрузки без диалогов
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", DOWNLOAD_DIR); // папка загрузки
        prefs.put("download.prompt_for_download", false); // отключаем запрос на скачивание
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Открываем страницу с файлами для скачивания
        driver.get(BASE_URL + "download");
    }

    @Test
    public void testFileDownload() {
        DownloadPage page = new DownloadPage(driver);
        DownloadLink fileLink = page.getDownloadLink(FILE_NAME);

        // Кликаем по ссылке для скачивания файла
        fileLink.click();

        // Ожидаем появления файла в папке загрузок (макс 30 сек)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean isDownloaded = wait.until(d -> {
            File downloadedFile = new File(DOWNLOAD_DIR + File.separator + FILE_NAME);
            return downloadedFile.exists() && downloadedFile.length() > 0;
        });

        // Проверяем, что файл успешно скачался
        assertTrue(isDownloaded, "Файл не был успешно загружен");
    }

    @AfterEach
    public void tearDown() {
        // Закрываем драйвер после теста
        if (driver != null) {
            driver.quit();
        }
    }
}
