package elements;

import base.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends BaseElement {
    private final Select select;

    public Dropdown(WebDriver driver) {
        super(driver, "%s", "/html/body/div[2]/div/div/select");
        WebElement element = driver.findElement(this.locator);
        this.select = new Select(element);
    }

    public void selectByVisibleText(String text) {
        select.selectByVisibleText(text);
    }

    public String getSelectedOptionText() {
        return select.getFirstSelectedOption().getText();
    }

    public boolean isOptionDisplayed(String value) {
        return driver.findElement(By.xpath("//option[@value='" + value + "']")).isDisplayed();
    }
}
