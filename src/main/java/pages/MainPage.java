package pages;

import courses.MonthDate;
import org.bouncycastle.asn1.pkcs.MacData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainPage extends BasePage {

  public By mainBanner = By.xpath("//h1[contains(text(), Авторские)]"); //TODO Насколько это корректно в Паблик классе объявлять паблик поле и стоит ли его сделать final?

  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//p[contains(@class, 'header2-menu__item-text')][text() = 'Курсы']")
  private WebElement courseMenuItem;

  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[@title = 'Тестирование']")
  private WebElement testingSubMenuItem;

  @FindBy(xpath = "//div[contains(@class, 'header2-menu_main')]//a[@title = 'Тестирование']/div[contains(@class, 'js-menu-subdropdown-trigger')]")
  private WebElement dropDownMenuTrigger;

  @FindBy(xpath = "//a[@title = 'Специализация QA Automation Engineer']")
  private WebElement specJavaAutomation;

  @FindBy(css = ".lessons__new-item-time")
  private List<WebElement> dateList;

  public MainPage(WebDriver driver) {
    super(driver, "/");
  }


  public WebElement getCourseMenuItem() {
    return courseMenuItem;
  }

  public WebElement getTestingSubMenuItem() {
    return testingSubMenuItem;
  }

  public WebElement getDropDownMenuTrigger() {
    return dropDownMenuTrigger;
  }

  public WebElement getSpecJavaAutomation() {
    return specJavaAutomation;
  }

  public MainPage moveToElementActions(Actions actions, WebElement element) {
    actions.moveToElement(element).perform();
    return this;
  }

  public MainPage moveToElementAndClickActions(Actions actions, WebElement element) {
    actions.moveToElement(element).click().build().perform();
    return this;
  }

  private List<LocalDate> getListOfDate() {
    return dateList.stream()
        .map((WebElement element) -> {
          return element.getText().trim();
        })
        .filter((String missDate) -> !missDate.contains("О дате старта будет объявлено позже"))
        .map((String dateStr) -> {
          Pattern pattern = Pattern.compile("С?\\s*(\\d+)\\s+([А-Яа-я]+)");
          Matcher matcher = pattern.matcher(dateStr);
          if (matcher.find()) {
            int day = Integer.parseInt(matcher.group(1));
            String month = matcher.group(2);
            return LocalDate.of(LocalDate.now().getYear(), convertMonth(month), day);
          }
          return null;
        })
        .collect(Collectors.toList());
  }

  private Month convertMonth(String mont) {
    for (MonthDate monthDate : MonthDate.values()) {
      if (monthDate.getName().equalsIgnoreCase(mont)) {
        return monthDate.getMonth();
      }
    }
    return null;
  }

  public LocalDate minDate(){
    return getListOfDate().stream()
        .sorted((LocalDate date1, LocalDate date2) -> {
         return  date1.compareTo(date2);
        })
        .collect(Collectors.toList())
        .get(0);
  }
  public LocalDate maxDate(){
    return getListOfDate().stream()
        .sorted((LocalDate date1, LocalDate date2) -> {
          return  date2.compareTo(date1);
        })
        .collect(Collectors.toList())
        .get(0);
  }

}
