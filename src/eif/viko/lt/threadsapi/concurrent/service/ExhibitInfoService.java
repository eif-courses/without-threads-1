package eif.viko.lt.threadsapi.concurrent.service;

import eif.viko.lt.threadsapi.concurrent.domain.ExhibitInfo;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitOption;

import java.util.List;

public class ExhibitInfoService {
  public ExhibitInfo retrieveExhibitInfo(String id) {

    List<ExhibitOption> exhibitOptions = List.of(
        new ExhibitOption(1, "gltf", "https://picsum.photos/200/300", "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(2, "obj", "https://picsum.photos/200/300", "https://eif.viko.lt", "https://eif.viko.lt")
    );

    ExhibitInfo exhibitInfo = new ExhibitInfo();
    exhibitInfo.setId(id);
    exhibitInfo.setExhibitOptionList(exhibitOptions);
    return exhibitInfo;
  }
}
