package pages;

import data.PageData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import support.SpringScoped;

public class SpecPage extends BasePage<SpecPage> {
  @FindBy(xpath = "//a[contains(@class, 'tn-atom')]/img[@class='tn-atom__img']")
  private WebElement appButton;

  @FindBy(xpath = "//div[contains(@class, 'tn-elem__33067862')]/a[text() = 'Успеть записаться']")
  private WebElement redirectButton;

  @Autowired
  public SpecPage(SpringScoped springScoped, SpecData page) {
    super(springScoped, "/lessons/" + page.getUrl());
  }

  public SpecPage checkRedirButtonText(String titleButton) {
    Assert.assertEquals(redirectButton.getText(), titleButton);
    return this;
  }

  public SpecPage clickAppButton() {
    actions.moveToElement(appButton).click().perform();
    return this;
  }

  public AppNonAuthPage clickRedirectButton(PageData pageData) {
    wait.until(ExpectedConditions.elementToBeClickable(redirectButton));
    actions.moveToElement(redirectButton).click().build().perform();
    return new AppNonAuthPage(springScoped, pageData);
  }

}
