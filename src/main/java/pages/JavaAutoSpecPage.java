package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class JavaAutoSpecPage extends BasePage{
  @FindBy(xpath = "//a[@class = 'tn-atom']/img[@class = 'tn-atom__img']")
  public
      WebElement appButton;

  @FindBy(xpath = "//div[contains(@class, 'tn-elem__3306786211601309572453')]/a[text() = 'Оставить заявку']")
  public
      WebElement redirectButton;

  public JavaAutoSpecPage(WebDriver driver) {
    super(driver, "/lessons/qa-auto-java-specialization/");
  }

  public JavaAutoSpecPage clickAppButton(Actions actions, WebElement element){
    actions.moveToElement(element).click().perform();
    return this;
  }

  public AppNonAuthPage clickRedirectButton(Actions actions, WebElement element){
    actions.moveToElement(element).click().build().perform();
    return new AppNonAuthPage(driver);
  }
}
