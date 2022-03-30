import exceptions.DriverNotSupported;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webdriverfactory.WDFactory;

import java.util.Locale;

public class BaseTest {
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected Actions actions;
  protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);
  //String driverName = "Chrome"; //System.getProperty("browser").toUpperCase(Locale.ROOT); // TODO Как перенести в WDF, а потом прокинуть driverName в BaseTest?

  @BeforeMethod
  public void setupWebDriver() throws DriverNotSupported {
    WDFactory wdFactory = new WDFactory();
    driver = wdFactory.getDriver(System.getProperty("browser").toUpperCase(Locale.ROOT));
  }

  @AfterMethod
  public void close() {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }
}
