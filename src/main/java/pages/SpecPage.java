package pages;

import com.google.inject.Inject;
import data.PageData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import support.GuiceScoped;

public class SpecPage extends BasePage<SpecPage> {
  @FindBy(xpath = "//a[contains(@class, 'tn-atom')]/img[@class='tn-atom__img']")
  private WebElement appButton;

  @FindBy(xpath = "//div[contains(@class, 'tn-elem__33067862')]/a[text() = 'Успеть записаться']")
  private WebElement redirectButton;

  @Inject
  public SpecPage(GuiceScoped guiceScoped, SpecPageData page) {
    super(guiceScoped, "/lessons/" + page.getUrl());
  }

  public SpecPage checkRedirButtonText(String titleButton) {
    Assert.assertEquals(redirectButton.getText(), titleButton);
    return this;
  }

  public SpecPage clickAppButton() {
    guiceScoped.actions.moveToElement(appButton).click().perform();
    return this;
  }

  public AppNonAuthPage clickRedirectButton(PageData pageData) {
    //    guiceScoped.wait.until(ExpectedConditions.elementToBeClickable(redirectButton));
    guiceScoped.actions.moveToElement(redirectButton).click().build().perform();
    return new AppNonAuthPage(guiceScoped, pageData);
  }

}
