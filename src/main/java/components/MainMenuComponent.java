package components;

import data.SpecData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

public class MainMenuComponent extends ComponentAbs<MainMenuComponent> {
  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//p[contains(@class, 'header2-menu__item-text')][text() = 'Курсы']")
  private WebElement courseMenuItem;

  //  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[@title = 'Тестирование']")
  private WebElement testingSubMenuItem = driver.findElement(By.xpath(String.format("//div[contains(@class, 'header2-menu_main')]"
      + "//a[@title = '%s']", SpecData.QA_AUTOMATION.getTypeData())));

  //  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[@title = 'Тестирование']/div[contains(@class, 'js-menu-subdropdown-trigger')]")
  private WebElement dropDownMenuTrigger = driver.findElement(By.xpath(String.format("//div[contains(@class, 'header2-menu_main')]"
      + "//a[@title = '%s']/div[contains(@class, 'js-menu-subdropdown-trigger')]", SpecData.QA_AUTOMATION.getTypeData())));

  //  @FindBy(xpath = "//a[@title = 'Специализация QA Automation Engineer']")
  private WebElement specJavaAutomation = driver.findElement(By.xpath(String.format("//a[@title = '%s']", SpecData.QA_AUTOMATION.getSubMenuName())));

  @Autowired
  public MainMenuComponent(WebDriver driver, Actions actions) {
    super(driver, actions);
  }

  public MainMenuComponent checkOpenSpecPage() {
    actions.moveToElement(courseMenuItem)
        .moveToElement(testingSubMenuItem)
        .moveToElement(dropDownMenuTrigger)
        .moveToElement(specJavaAutomation).click().build().perform();
    return this;
  }

}
