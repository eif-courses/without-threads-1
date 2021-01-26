package eif.viko.lt.threadsapi.concurrent;

import eif.viko.lt.threadsapi.concurrent.domain.Exhibit;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitInfo;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitRating;
import eif.viko.lt.threadsapi.concurrent.service.ExhibitInfoService;
import eif.viko.lt.threadsapi.concurrent.service.ExhibitRatingService;
import eif.viko.lt.threadsapi.concurrent.ui.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class ExhibitService {
  private final ExhibitInfoService exhibitInfoService;
  private final ExhibitRatingService exhibitRatingService;

  public ExhibitService(ExhibitInfoService exhibitInfoService, ExhibitRatingService exhibitRatingService) {
    this.exhibitInfoService = exhibitInfoService;
    this.exhibitRatingService = exhibitRatingService;
  }

  public Exhibit retrieveExhibitDetails(String id) throws InterruptedException {

    ExhibitInfoRunnable exhibitInfoRunnable = new ExhibitInfoRunnable(id);
    ExhibitRatingRunnable exhibitRatingRunnable = new ExhibitRatingRunnable(id);

    Thread infoThread = new Thread(exhibitInfoRunnable);
    Thread ratingThread = new Thread(exhibitRatingRunnable);


    infoThread.start();
    ratingThread.start();
    JFrame frame = new JFrame("Museum of Electronics & Informatics Faculty");

    SwingUtilities.invokeLater(() -> {
      JOptionPane pane = new JOptionPane();
      pane.setOptions(new Object[]{});
      pane.setMessage("Loading...");
      JProgressBar jProgressBar = new JProgressBar();
      jProgressBar.setForeground(Color.green);
      jProgressBar.setIndeterminate(true);
      pane.add(jProgressBar, 1);
      JDialog dialog = pane.createDialog(frame, "Museum of Electronics & Informatics Faculty");

      dialog.setVisible(true);
    });


    infoThread.join();
    ratingThread.join();
    frame.dispose();

    System.out.println(infoThread.isAlive());

    ExhibitInfo exhibitInfo = exhibitInfoRunnable.getExhibitInfo();
    ExhibitRating exhibitRating = exhibitRatingRunnable.getExhibitRating();

    return new Exhibit(id, exhibitInfo, exhibitRating);
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    ExhibitInfoService infoService = new ExhibitInfoService();
    ExhibitRatingService ratingService = new ExhibitRatingService();
    ExhibitService exhibitService = new ExhibitService(infoService, ratingService);
    String id = "EIF2021";
    Exhibit exhibit = exhibitService.retrieveExhibitDetails(id);

    SwingUtilities.invokeLater(() -> {
      try {
        new GUI(exhibit);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  private class ExhibitInfoRunnable implements Runnable {

    private final String id;
    private ExhibitInfo exhibitInfo;

    public ExhibitInfoRunnable(String id) {
      this.id = id;
    }

    public ExhibitInfo getExhibitInfo() {
      return exhibitInfo;
    }

    @Override
    public void run() {
      try {
        exhibitInfo = exhibitInfoService.retrieveExhibitInfo(id);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private class ExhibitRatingRunnable implements Runnable {
    private final String id;
    private ExhibitRating exhibitRating;

    private ExhibitRatingRunnable(String id) {
      this.id = id;
    }

    public ExhibitRating getExhibitRating() {
      return exhibitRating;
    }

    @Override
    public void run() {
      try {
        exhibitRating = exhibitRatingService.retrieveExhibitRating(id);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}