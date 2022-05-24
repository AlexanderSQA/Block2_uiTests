package pages;

public enum SpecPageData {
  QA("qa-auto-java-specialization/");

  private final String url;


  SpecPageData(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }


}
