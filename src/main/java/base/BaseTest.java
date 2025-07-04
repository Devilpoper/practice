package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

/**
 * Базовый класс для UI-тестов на чистом Selenium WebDriver, без WebDriverManager.
 */
public abstract class BaseTest {
    protected WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com/";

    /**
     * Настройка окружения перед каждым тестом:
     * - Опции Chrome
     * - Таймауты
     * - Открытие базового URL
     */
    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--disable-gpu",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--remote-allow-origins=*",
                "--disable-blink-features=AutomationControlled"
        );

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(BASE_URL + "/");
    }

    /**
     * Завершение работы WebDriver после каждого теста.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
