package pages;

public enum SpecData {
  QA("qa-auto-java-specialization/");

  private final String url;


  SpecData(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }


}
