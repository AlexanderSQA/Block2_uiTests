import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webdriverfactory.WDFactory;
import java.util.Locale;

@Component
public class BaseTest {
  @Autowired
  protected WebDriver driver;
  @Autowired
  protected WebDriverWait wait;
  @Autowired
  protected Actions actions;
  protected org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);


  @BeforeMethod
  public void setupWebDriver() {
    WDFactory wdFactory = new WDFactory();
    driver = wdFactory.getDriver(System.getProperty("browser").toUpperCase(Locale.ROOT));
    wait = new WebDriverWait(driver, 4);
    actions = new Actions(driver);
  }

  @AfterMethod
  public void close() {
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }
}
