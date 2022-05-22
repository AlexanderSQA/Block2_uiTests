package pages;

import courses.FavoriteCourse;
import courses.MonthDate;
import courses.SpecializationCourse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class MainPage extends BasePage<MainPage> {


  @Autowired
  public MainPage(WebDriver driver) {
    super(driver, "/");
  }

  private List<WebElement> collectValidDateList() {
    FavoriteCourse favoriteCourse = new FavoriteCourse(driver);
    SpecializationCourse specializationCourse = new SpecializationCourse(driver);
    return Stream.of(favoriteCourse.getDateList(), specializationCourse.getDateList())
        .flatMap(Collection::stream)
        .collect(Collectors.toList());
  }

  private List<LocalDate> getListOfDate() {
    return collectValidDateList().stream()
        .map((WebElement element) -> {
          return element.getText().trim();
        })
        .filter((String missDate) -> !missDate.contains("О дате старта будет объявлено позже") && !missDate.matches("В\\s+[А-Яа-я]+\\s+.*"))
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

  private Month convertMonth(String month) {
    for (MonthDate monthDate : MonthDate.values()) {
      if (monthDate.getName().equalsIgnoreCase(month)) {
        return monthDate.getMonth();
      }
    }
    return null;
  }

  public LocalDate minDate() {
    return getListOfDate().stream()
        .sorted((LocalDate date1, LocalDate date2) -> {
          return date1.compareTo(date2);
        })
        .collect(Collectors.toList())
        .get(0);
  }

  public LocalDate maxDate() {
    return getListOfDate().stream()
        .sorted((LocalDate date1, LocalDate date2) -> {
          return date2.compareTo(date1);
        })
        .collect(Collectors.toList())
        .get(0);
  }

  public void waitUntilLessonsDateBeVisible() {
    WebDriverWait wait = new WebDriverWait(driver, 20);
    wait.until(ExpectedConditions.visibilityOfAllElements(collectValidDateList()));
  }

}
