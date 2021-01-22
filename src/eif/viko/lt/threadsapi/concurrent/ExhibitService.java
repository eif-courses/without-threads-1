package eif.viko.lt.threadsapi.concurrent;

import eif.viko.lt.threadsapi.concurrent.domain.Exhibit;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitInfo;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitRating;
import eif.viko.lt.threadsapi.concurrent.service.ExhibitInfoService;
import eif.viko.lt.threadsapi.concurrent.service.ExhibitRatingService;
import eif.viko.lt.threadsapi.concurrent.ui.GUI;

import java.io.IOException;

public class ExhibitService {
  private final ExhibitInfoService exhibitInfoService;
  private final ExhibitRatingService exhibitRatingService;

  public ExhibitService(ExhibitInfoService exhibitInfoService, ExhibitRatingService exhibitRatingService) {
    this.exhibitInfoService = exhibitInfoService;
    this.exhibitRatingService = exhibitRatingService;
  }

  public Exhibit retrieveExhibitDetails(String id){
    ExhibitInfo exhibitInfo = exhibitInfoService.retrieveExhibitInfo(id);
    ExhibitRating exhibitRating = exhibitRatingService.retrieveExhibitRating(id);
    return new Exhibit(id, exhibitInfo, exhibitRating);
  }

  public static void main(String[] args) throws IOException {
    ExhibitInfoService infoService = new ExhibitInfoService();
    ExhibitRatingService ratingService = new ExhibitRatingService();
    ExhibitService exhibitService = new ExhibitService(infoService, ratingService);
    String id = "EIF2021";
    Exhibit exhibit = exhibitService.retrieveExhibitDetails(id);

    new GUI(exhibit);

    System.out.println(exhibit.getExhibitRating().getLikeCount());

  }
}
