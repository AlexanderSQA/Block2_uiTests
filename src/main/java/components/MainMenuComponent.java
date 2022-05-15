package components;

import data.SpecData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

public class MainMenuComponent extends ComponentAbs<MainMenuComponent> {
  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//p[contains(@class, 'header2-menu__item-text')][text() = 'Курсы']")
  private WebElement courseMenuItem;

  private String subMenuItem = "//div[contains(@class, 'header2-menu_main')]//a[@title = '%s']";

  private String dropDownMenuTrigger = "//div[contains(@class, 'header2-menu_main')]//a[@title = '%s']/div[contains(@class, 'js-menu-subdropdown-trigger')]";

  private String specCourse = "//a[@title = '%s']";

  @Autowired
  public MainMenuComponent(WebDriver driver) {
    super(driver);
  }

  public MainMenuComponent checkOpenSpecPage(SpecData specData) {
    actions.moveToElement(courseMenuItem)
        .moveToElement(driver.findElement(By.xpath(String.format(subMenuItem, specData.getTypeData().getName()))))
        .moveToElement(driver.findElement(By.xpath(String.format(dropDownMenuTrigger, specData.getTypeData().getName()))))
        .moveToElement(driver.findElement(By.xpath(String.format(specCourse, specData.getSubMenuName())))).click().build().perform();
    return this;
  }

}
