package webdriverfactory.options;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Remote implements IBrowserOptions{
  @Override
  public WebDriver getDriver() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, System.getProperty("browser.name"));
    capabilities.setCapability(CapabilityType.BROWSER_VERSION, System.getProperty("browser.version"));
    URL url = null;
    try {
      url = new URL(System.getProperty("remote.url"));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return new RemoteWebDriver(url, capabilities);
  }
}
