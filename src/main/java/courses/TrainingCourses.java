package courses;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import support.GuiceScoped;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrainingCourses extends MainPage {

  @FindBy(css = ".lessons__new-item-bg")
  private List<WebElement> trainingCourses;

  @FindBy(css = ".lessons__new-item-price")
  private List<WebElement> costOfCourses;

  @FindBy(css = ".lessons__new-item-title")
  private List<WebElement> titleOfCourses;

  @Inject
  public TrainingCourses(GuiceScoped guiceScoped) {
    super(guiceScoped);
  }

  private Integer getMinCost() {
    return costOfCourses.stream()
        .map(element -> Integer.parseInt(element.getText().replaceAll("\\D+", "")))
        .reduce(Integer.MAX_VALUE, (a, b) -> Integer.min(a, b));
  }

  private Integer getMaxCost() {
    return costOfCourses.stream()
        .map(element -> Integer.parseInt(element.getText().replaceAll("\\D+", "")))
        .reduce(Integer.MIN_VALUE, Integer::max);
  }

  public String getTitleCourseWithMinCost() {
    Optional<String> optional =
        titleOfCourses.stream()
            .map((WebElement element) -> {
              WebElement element1 =
                  element.findElement(By.xpath(String.format("//div[contains(text(), '%s')]//../../div[contains(@class, 'lessons__new-item-title')]",
                      getMinCost())));
              return element1.getText();
            })
            .findFirst();
    return optional.orElse("");
  }

  public String getTitleCourseWithMaxCost() {
    int temp = getMaxCost();
    Optional<String> optional =
        titleOfCourses.stream()
            .map((WebElement element) -> {
              WebElement element1 =
                  element.findElement(By.xpath(String.format("//div[contains(text(), '%d')]//../../div[contains(@class, 'lessons__new-item-title')]",
                      temp)));
              return element1.getText();
            })
            .findFirst();
    return optional.orElse("");
  }


}
