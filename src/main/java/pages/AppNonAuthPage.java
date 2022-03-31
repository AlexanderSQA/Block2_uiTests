package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppNonAuthPage extends BasePage{

  @FindBy(xpath = "//div[@class = 'assessment-title__main_new']/a[contains(text(), 'Специализация QA')]")
  public
      WebElement noRefTitle;

  public AppNonAuthPage(WebDriver driver) {
    super(driver, "/assessment/275/");
  }
}
