package pages;

import data.PageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

@Component
public class AppNonAuthPage extends BasePage<AppNonAuthPage> {
    private final String id;

    /**
     * Не совсем понял для чего нужен ENUM с заранее определенными данными
     * Пришлось временно выпилить.
     * @param driver
     */
    @Autowired
    public AppNonAuthPage(WebDriver driver) {
        super(driver, "/assessment/275");
        id = "275";
    }

    public WebElement getNoRefTitle() {
        return driver.findElement(By.xpath(String.format("//div[@class = 'assessment-title__main_new']/a[contains(text(), %s)]", id)));
    }

    public AppNonAuthPage checkNonAuthPageTitle() {
        Assert.assertEquals(getNoRefTitle().getText(), "СПЕЦИАЛИЗАЦИЯ QA AUTOMATION ENGINEER");
        return this;
    }

}
