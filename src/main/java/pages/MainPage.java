package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

  public By mainBanner = By.xpath("//h1[contains(text(), Авторские)]"); //TODO Насколько это корректно в Паблик классе объявлять паблик поле и стоит ли его сделать final?

  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//p[contains(@class, 'header2-menu__item-text')][text() = 'Курсы']")
  private WebElement courseMenuItem;

  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[@title = 'Тестирование']")
  private WebElement testingSubMenuItem;

  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[@title = 'Тестирование']/div[contains(@class, 'js-menu-subdropdown-trigger')]")
  private WebElement dropDownMenuTrigger;

  @FindBy(xpath = "//a[@title = 'Специализация QA Automation Engineer']")
  private WebElement specJavaAutomation;

  public MainPage(WebDriver driver) {
    super(driver, "/");
  }


  public WebElement getCourseMenuItem() {
    return courseMenuItem;
  }

  public WebElement getTestingSubMenuItem() {
    return testingSubMenuItem;
  }

  public WebElement getDropDownMenuTrigger() {
    return dropDownMenuTrigger;
  }

  public WebElement getSpecJavaAutomation() {
    return specJavaAutomation;
  }

  public MainPage moveToElementActions(Actions actions, WebElement element) {
    actions.moveToElement(element).perform();
    return this;
  }

  public MainPage moveToElementAndClickActions(Actions actions, WebElement element) {
    actions.moveToElement(element).click().build().perform();
    return this;
  }
}
