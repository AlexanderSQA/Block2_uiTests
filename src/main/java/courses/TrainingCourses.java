package courses;

import com.google.inject.Inject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import support.GuiceScoped;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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

  private Map<List<String>, List<Integer>> getMinCostOfTrainingCourses() {
    return trainingCourses.stream()
        .filter((WebElement element) -> costOfCourses.stream().min((o1, o2) -> ))
        .collect(Collectors.toMap(k -> getTitle(), v -> getCost()));
  }

  private Map<List<String>, List<Integer>> getMaxCostOfTrainingCourses() {
    return trainingCourses.stream()
        .filter((WebElement element) -> costOfCourses.stream().max())
        .collect(Collectors.toMap(k -> getTitle(), v -> getCost()));
  }

  private Integer getMinCost() {
    return costOfCourses.stream()
        .map(element -> Integer.parseInt(element.getText().replaceAll("\\D+", "")))
        .sorted(Comparator.naturalOrder())
        .collect(Collectors.toList())
        .get(0);
  }

  private Integer getMaxCost() {
    return costOfCourses.stream()
        .map(element -> Integer.parseInt(element.getText().replaceAll("\\D+", "")))
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList())
        .get(0);
  }

  private List<Integer> getCost() {
    return costOfCourses.stream()
        .map(element -> Integer.parseInt(element.getText().replaceAll("\\D+", "")))
        .collect(Collectors.toList());
  }

  private List<String> getTitle() {
    return titleOfCourses.stream()
        .map((WebElement::getText))
        .collect(Collectors.toList());
  }


}
