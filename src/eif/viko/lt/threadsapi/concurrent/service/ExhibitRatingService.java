package eif.viko.lt.threadsapi.concurrent.service;

import eif.viko.lt.threadsapi.concurrent.domain.ExhibitRating;

public class ExhibitRatingService {
  public ExhibitRating retrieveExhibitRating(String id) {
    return new ExhibitRating(4.2, 3452);
  }
}
