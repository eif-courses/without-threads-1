package eif.viko.lt.threadsapi.concurrent.domain;

import java.util.List;

public class ExhibitInfo {
  private String id;
  private List<ExhibitOption> exhibitOptionList;

  public String getId() {
    return id;
  }

  public List<ExhibitOption> getExhibitOptionList() {
    return exhibitOptionList;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setExhibitOptionList(List<ExhibitOption> exhibitOptionList) {
    this.exhibitOptionList = exhibitOptionList;
  }

  @Override
  public String toString() {
    return "ExhibitInfo{" +
        "id='" + id + '\'' +
        ", exhibitOptionList=" + exhibitOptionList +
        '}';
  }
}
