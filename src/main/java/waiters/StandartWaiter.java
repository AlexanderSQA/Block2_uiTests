package waiters;

import org.openqa.selenium.WebDriver;

public class StandartWaiter {

  private WebDriver driver = null;
  long wainingInMills = 4000L;

  public StandartWaiter(WebDriver driver) {
    this.driver = driver;
  }


}
