package eif.viko.lt.threadsapi.concurrent.domain;

public class ExhibitRating {
  private final double starCount;
  private final long likeCount;

  public ExhibitRating(double starCount, long likeCount) {
    this.starCount = starCount;
    this.likeCount = likeCount;
  }

  public double getStarCount() {
    return starCount;
  }

  public long getLikeCount() {
    return likeCount;
  }

  @Override
  public String toString() {
    return "ExhibitRating{" +
        "starCount=" + starCount +
        ", likeCount=" + likeCount +
        '}';
  }
}
