package components;

import com.google.inject.Inject;
import data.SpecData;
import lombok.var;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import support.GuiceScoped;


public class MainMenuComponent extends ComponentAbs<MainMenuComponent> {
  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//p[contains(@class, 'header2-menu__item-text')][text() = 'Курсы']")
  private WebElement courseMenuItem;

  private String testingSubMenuItem = "//div[contains(@class, 'header2-menu_main')]//a[@title = '%s']";

  private String dropDownMenuTrigger = "//div[contains(@class, 'header2-menu_main')]//a[@title = '%s']/div[contains(@class, 'js-menu-subdropdown-trigger')]";

  private String specializationPage = "//a[@title = '%s']";

  private String trainingCourses = "//a[@title = 'Подготовительные курсы']";

  @Inject
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

  public MainMenuComponent openTrainingCoursePage() {
    guiceScoped.actions.moveToElement(courseMenuItem)
        .moveToElement(guiceScoped.driver.findElement(By.xpath(trainingCourses))).click().build().perform();
    return this;
  }
}
