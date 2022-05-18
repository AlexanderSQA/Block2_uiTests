package components;

import data.SpecData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainMenuComponent extends ComponentAbs<MainMenuComponent> {
  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//p[contains(@class, 'header2-menu__item-text')][text() = 'Курсы']")
  private WebElement courseMenuItem;

//  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[@title = 'Тестирование']")
  private String testingSubMenuItem = "//div[contains(@class, 'header2-menu_main')]//a[@title = '%s']";

//  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[@title = 'Тестирование']/div[contains(@class, 'js-menu-subdropdown-trigger')]")
  private String dropDownMenuTrigger = "//div[contains(@class, 'header2-menu_main')]//a[@title = '%s']/div[contains(@class, 'js-menu-subdropdown-trigger')]";

//  @FindBy(xpath = "//a[@title = 'Специализация QA Automation Engineer']")
  private String specializationPage = "//a[@title = '%s']";

  @Autowired
  public MainMenuComponent(WebDriver driver, Actions actions) {
    super(driver, actions);
  }

  public MainMenuComponent checkOpenSpecPage(SpecData specData) {
    actions.moveToElement(courseMenuItem)
        .moveToElement(driver.findElement(By.xpath(String.format(testingSubMenuItem,specData.getTypeData().getName()))))
        .moveToElement(driver.findElement(By.xpath(String.format(dropDownMenuTrigger,specData.getTypeData().getName()))))
        .moveToElement(driver.findElement(By.xpath(String.format(specializationPage, specData.getSubMenuName())))).click().build().perform();
    return this;
  }

}
