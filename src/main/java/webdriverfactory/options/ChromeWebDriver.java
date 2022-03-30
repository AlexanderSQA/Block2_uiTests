package webdriverfactory.options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriver implements IBrowserOptions {

  @Override
  public WebDriver getDriver() {
    ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
    options.addArguments("--kiosk");

    return new ChromeDriver(options);


  }
}
