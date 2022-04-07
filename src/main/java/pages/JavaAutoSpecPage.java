package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaAutoSpecPage extends BasePage {
  @FindBy(xpath = "//a[contains(@class, 'tn-atom')]/img[contains(@class, 'tn-atom__img')]")
  private WebElement appButton;

  @FindBy(xpath = "//div[contains(@class, 'tn-elem__3306786211601309572453')]/a[text() = 'Оставить заявку']")
  private WebElement redirectButton;

  public JavaAutoSpecPage(WebDriver driver) {
    super(driver, "/lessons/qa-auto-java-specialization/");
  }

  public WebElement getAppButton() {
    return appButton;
  }

  public WebElement getRedirectButton() {
    return redirectButton;
  }

  public JavaAutoSpecPage clickAppButton(Actions actions, WebElement element) {
    actions.moveToElement(element).click().perform();
    return this;
  }

  public AppNonAuthPage clickRedirectButton(Actions actions, WebElement element) {
    actions.moveToElement(element).click().build().perform();
    return new AppNonAuthPage(driver);
  }

  public void waitButtonBeVisible(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, 4);
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }
}
