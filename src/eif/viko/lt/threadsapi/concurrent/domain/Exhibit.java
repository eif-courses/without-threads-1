package eif.viko.lt.threadsapi.concurrent.domain;

public class Exhibit {
  private final String id;
  private final ExhibitInfo exhibitInfo;
  private final ExhibitRating exhibitRating;

  public Exhibit(String id, ExhibitInfo exhibitInfo, ExhibitRating exhibitRating) {
    this.id = id;
    this.exhibitInfo = exhibitInfo;
    this.exhibitRating = exhibitRating;
  }

  public String getId() {
    return id;
  }

  public ExhibitInfo getExhibitInfo() {
    return exhibitInfo;
  }

  public ExhibitRating getExhibitRating() {
    return exhibitRating;
  }

  @Override
  public String toString() {
    return "Exhibit{" +
        "id='" + id + '\'' +
        ", exhibitInfo=" + exhibitInfo +
        ", exhibitRating=" + exhibitRating +
        '}';
  }
}
