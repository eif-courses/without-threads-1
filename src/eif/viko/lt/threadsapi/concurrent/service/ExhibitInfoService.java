package eif.viko.lt.threadsapi.concurrent.service;

import eif.viko.lt.threadsapi.concurrent.domain.ExhibitInfo;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitOption;

import java.util.List;

import static java.lang.Thread.sleep;

public class ExhibitInfoService {
  public ExhibitInfo retrieveExhibitInfo(String id) throws InterruptedException {

    sleep(11);
    List<ExhibitOption> exhibitOptions = List.of(
        new ExhibitOption(1, "Oscillograph S1-19A USSR 1972", "https://picsum.photos/200/300", "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(2, "High-level diode in the USSR 1970", "https://picsum.photos/200/300", "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(3, "Radio lamp GU-23A USSR 1987", "https://picsum.photos/200/300", "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(4, "Household computer ROBIK USSR 1987", "https://picsum.photos/200/300", "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(5, "Laboratory detector layout Lithuania 1976", "https://picsum.photos/200/300", "https://eif.viko.lt", "https://eif.viko.lt")
        );

    ExhibitInfo exhibitInfo = new ExhibitInfo();
    exhibitInfo.setId(id);
    exhibitInfo.setExhibitOptionList(exhibitOptions);
    return exhibitInfo;
  }
}
