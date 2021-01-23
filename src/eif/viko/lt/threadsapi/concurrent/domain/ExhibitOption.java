package eif.viko.lt.threadsapi.concurrent.domain;

public class ExhibitOption {
  private final Integer id;
  private final String name;
  private final String imageURL;
  private final String soundURL;
  private final String modelURL;

  public ExhibitOption(Integer id, String name, String imageURL, String soundURL, String modelURL) {
    this.id = id;
    this.name = name;
    this.imageURL = imageURL;
    this.soundURL = soundURL;
    this.modelURL = modelURL;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getImageURL() {
    return imageURL;
  }

  public String getSoundURL() {
    return soundURL;
  }

  public String getModelURL() {
    return modelURL;
  }

  @Override
  public String toString() {
    return "ExhibitOption{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", imageURL='" + imageURL + '\'' +
        ", soundURL='" + soundURL + '\'' +
        ", modelURL='" + modelURL + '\'' +
        '}';
  }
}
