package components;

import data.SpecData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import support.GuiceScoped;


public class MainMenuComponent extends ComponentAbs<MainMenuComponent> {
  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//p[contains(@class, 'header2-menu__item-text')][text() = 'Курсы']")
  private WebElement courseMenuItem;

  private String testingSubMenuItem = "//div[contains(@class, 'header2-menu_main')]//a[@title = '%s']";

  private String dropDownMenuTrigger = "//div[contains(@class, 'header2-menu_main')]//a[@title = '%s']/div[contains(@class, 'js-menu-subdropdown-trigger')]";

  private String specializationPage = "//a[@title = '%s']";


  public MainMenuComponent(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  public MainMenuComponent checkOpenSpecPage(SpecData specData) {
    guiceScoped.actions.moveToElement(courseMenuItem)
        .moveToElement(guiceScoped.driver.findElement(By.xpath(String.format(testingSubMenuItem, specData.getTypeData().getName()))))
        .moveToElement(guiceScoped.driver.findElement(By.xpath(String.format(dropDownMenuTrigger, specData.getTypeData().getName()))))
        .moveToElement(guiceScoped.driver.findElement(By.xpath(String.format(specializationPage, specData.getSubMenuName())))).click().build().perform();
    return this;
  }

}
