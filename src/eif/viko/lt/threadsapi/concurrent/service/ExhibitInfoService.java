package eif.viko.lt.threadsapi.concurrent.service;

import eif.viko.lt.threadsapi.concurrent.domain.ExhibitInfo;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitOption;

import java.io.*;
import java.net.URL;
import java.util.List;
import org.apache.commons.io.FilenameUtils;

import static java.lang.Thread.sleep;

public class ExhibitInfoService {
  public ExhibitInfo retrieveExhibitInfo(String id) throws InterruptedException, IOException {

    sleep(10);
    String path = new File("").getAbsolutePath();
    String image1 = downloadImage("https://picsum.photos/200/300", path);
    String randomImage = path+"\\"+image1;

    List<ExhibitOption> exhibitOptions = List.of(
        new ExhibitOption(1, "Oscillograph S1-19A USSR 1972", randomImage, "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(2, "High-level diode in the USSR 1970", randomImage, "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(3, "Radio lamp GU-23A USSR 1987", randomImage, "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(4, "Household computer ROBIK USSR 1987", randomImage, "https://eif.viko.lt", "https://eif.viko.lt"),
        new ExhibitOption(5, "Laboratory detector layout Lithuania 1976", randomImage, "https://eif.viko.lt", "https://eif.viko.lt")
        );

    ExhibitInfo exhibitInfo = new ExhibitInfo();
    exhibitInfo.setId(id);
    exhibitInfo.setExhibitOptionList(exhibitOptions);
    return exhibitInfo;
  }

  public static String downloadImage(String sourceUrl, String targetDirectory)
      throws IOException {
    URL imageUrl = new URL(sourceUrl);
    try (InputStream imageReader = new BufferedInputStream(
        imageUrl.openStream());
         OutputStream imageWriter = new BufferedOutputStream(
             new FileOutputStream(targetDirectory + File.separator
                 + FilenameUtils.getName(sourceUrl)));)
    {
      int readByte;

      while ((readByte = imageReader.read()) != -1)
      {
        imageWriter.write(readByte);
      }
    }
    return FilenameUtils.getName(sourceUrl);
  }

}
