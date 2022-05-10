package pages;

import data.PageData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class AppNonAuthPage extends BasePage {

  @Autowired
  public AppNonAuthPage(WebDriver driver, PageData page) {
    super(driver, "/assessment/" + page.getId());
  }

  public WebElement getNoRefTitle() {
    return driver.findElement(By.xpath(String.format("//div[@class = 'assessment-title__main_new']/a[contains(text(), %s)]", PageData.valueOf("NAME"))));
  }

}
