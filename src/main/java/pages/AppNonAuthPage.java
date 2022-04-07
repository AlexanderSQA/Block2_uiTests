package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppNonAuthPage extends BasePage {

  @FindBy(xpath = "//div[@class = 'assessment-title__main_new']/a[contains(text(), 'Специализация QA')]")
  private WebElement noRefTitle;

  public WebElement getNoRefTitle() {
    return noRefTitle;
  }

  public AppNonAuthPage(WebDriver driver) {
    super(driver, "/assessment/275/");
  }
}
