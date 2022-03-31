package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

  public By mainBanner = By.xpath("//h1[contains(text(), Авторские)]"); //TODO Насколько это корректно в Паблик классе объявлять паблик поле и стоит ли его сделать final?

  @FindBy(xpath = "//div[@class='header2-menu header2-menu_main']//p[@class = 'header2-menu__item-text' and text() = 'Курсы']")
  public
      WebElement courseMenuItem;

  @FindBy(xpath = "//div[@class = 'header2-menu header2-menu_main']//a[@title = 'Тестирование']")
  public
      WebElement testingSubMenuItem;

  @FindBy(xpath = "//div[@class = 'header2-menu header2-menu_main']//a[@title = 'Тестирование']/div[contains(@class, 'js-menu-subdropdown-trigger')]")
  public
      WebElement dropDownMenuTrigger;

  @FindBy(xpath = "//a[@title = 'Специализация QA Automation Engineer']")
  public
      WebElement specJavaAutomation;

  public MainPage(WebDriver driver) {
    super(driver, "/");
  }

  public void moveToElementActions(Actions actions,WebElement element){
    actions.moveToElement(element).perform();
  }
  public void moveToElementAndClickActions(Actions actions, WebElement element){
    actions.moveToElement(element).click().build().perform();
  }
}
