package pages;

import data.PageData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;

public class SpecPage extends BasePage<SpecPage> {
  @FindBy(xpath = "//a[contains(@class, 'tn-atom')]/img[@class='tn-atom__img']")
  private WebElement appButton;

  @FindBy(xpath = "//div[contains(@class, 'tn-elem__33067862')]/a[text() = 'Успеть записаться']")
  private WebElement redirectButton;

  @Autowired
  public SpecPage(WebDriver driver, SpecData page) {
    super(driver, "/lessons/" + page.getUrl());
  }

  public WebElement getAppButton() {
    return appButton;
  }

  public WebElement getRedirectButton() {
    return redirectButton;
  }

  public SpecPage clickAppButton() {
    actions.moveToElement(appButton).click().perform();
    return this;
  }

  public AppNonAuthPage clickRedirectButton() {
    wait.until(ExpectedConditions.elementToBeClickable(redirectButton));
    actions.moveToElement(redirectButton).click().build().perform();
    return new AppNonAuthPage(driver, PageData.QA);
  }

  public void waitPageBeVisible(String path) {
    wait.until(ExpectedConditions.urlContains(path));
  }


}