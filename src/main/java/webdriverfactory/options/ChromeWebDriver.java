package webdriverfactory.options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver implements IBrowserOptions {

  @Override
  public WebDriver getDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--kiosk");
    options.addArguments("--incognito");
    return new ChromeDriver(options);


  }
}
