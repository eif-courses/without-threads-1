package eif.viko.lt.threadsapi.concurrent.service;

import eif.viko.lt.threadsapi.concurrent.domain.ExhibitRating;

import static java.lang.Thread.sleep;

public class ExhibitRatingService {
  public ExhibitRating retrieveExhibitRating(String id) throws InterruptedException {
    sleep(1000);
    return new ExhibitRating(4.2, 3452);
  }
}
