package tests;

import org.junit.jupiter.api.Test;
import pages.UploadPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadTest extends BaseTest {

    @Test
    public void testFileUpload() throws Exception {
        // Создаем временный файл для загрузки (если не существует)
        File testFile = new File("test.txt");
        if (!testFile.exists()) {
            assertTrue(testFile.createNewFile(), "Не удалось создать временный файл.");
        }

        // Открываем страницу загрузки файлов
        UploadPage uploadPage = new UploadPage(driver);
        driver.get("https://the-internet.herokuapp.com/upload");

        // Загружаем файл через поле input и нажимаем кнопку "Upload"
        uploadPage.fileInput().sendKeys(testFile.getAbsolutePath());
        uploadPage.uploadButton().click();

        // Проверяем сообщение об успешной загрузке и имя загруженного файла
        assertEquals("File Uploaded!", uploadPage.successMessage().getText(), "Сообщение об успешной загрузке некорректно");
        assertEquals(testFile.getName(), uploadPage.uploadedFileName().getText(), "Имя загруженного файла не совпадает");

        // Удаляем временный файл после теста
        assertTrue(testFile.delete(), "Не удалось удалить временный файл");
    }
}
