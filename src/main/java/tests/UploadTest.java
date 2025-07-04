package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.UploadPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadTest extends BaseTest {

    @Test
    public void testFileUpload() throws Exception {
        // Подготовка временного файла
        File testFile = new File("test.txt");
        if (!testFile.exists()) {
            assertTrue(testFile.createNewFile(), "Не удалось создать временный файл.");
        }

        // Открытие страницы и взаимодействие
        UploadPage uploadPage = new UploadPage(driver);
        driver.get("https://the-internet.herokuapp.com/upload");

        uploadPage.fileInput().sendKeys(testFile.getAbsolutePath());
        uploadPage.uploadButton().click();

        // Проверка успешной загрузки
        assertEquals("File Uploaded!", uploadPage.successMessage().getText(), "Сообщение об успешной загрузке некорректно");
        assertEquals(testFile.getName(), uploadPage.uploadedFileName().getText(), "Имя загруженного файла не совпадает");

        // Очистка
        assertTrue(testFile.delete(), "Не удалось удалить временный файл");
    }
}
