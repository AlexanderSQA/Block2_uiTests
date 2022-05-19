package webdriverfactory;

import exceptions.DriverNotSupported;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.MouseListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import webdriverfactory.options.ChromeWebDriver;
import webdriverfactory.options.FirefoxWebDriver;
import webdriverfactory.options.OperaWebDriver;

@Component
public class WDFactory {

    /**
     * Компонент с логикой.
     * Ищем с похожей сигнатурой (WebDriver) и вставляем туда, где autowierd
     * @return
     */
    @Bean
    public WebDriver defaultDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public EventFiringWebDriver getDriver(String browserName) {
        switch (Browsers.valueOf(browserName)) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeWebDriver().getDriver());
                driver.register(new MouseListeners());
                return driver;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new EventFiringWebDriver(new OperaWebDriver().getDriver());
                driver.register(new MouseListeners());
                return driver;
            case FIREFOX:
                WebDriverManager.operadriver().setup();
                driver = new EventFiringWebDriver(new FirefoxWebDriver().getDriver());
                driver.register(new MouseListeners());
                return driver;
            default:
                try {
                    throw new DriverNotSupported("Unexpected value: " + browserName);
                } catch (DriverNotSupported driverNotSupported) {
                    driverNotSupported.printStackTrace();
                }
                return null;
        }
    }
}
