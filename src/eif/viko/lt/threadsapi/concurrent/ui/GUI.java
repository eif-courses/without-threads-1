package eif.viko.lt.threadsapi.concurrent.ui;

import eif.viko.lt.threadsapi.concurrent.domain.Exhibit;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitOption;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class GUI extends JFrame {

  public GUI(Exhibit exhibit) throws IOException {

    List<ExhibitOption> exhibitOptionList = exhibit.getExhibitInfo().getExhibitOptionList();

    long likes = exhibit.getExhibitRating().getLikeCount();


    JPanel jPanel = new JPanel(new GridLayout(exhibitOptionList.size(),1 ));
    setSize(new Dimension(1024, 768));

    for (ExhibitOption e : exhibit.getExhibitInfo().getExhibitOptionList()) {
      jPanel.add(new JLabel(String.format("%s %s", "Model: ",e.getModelType())));
      String path = e.getImageURL();
      URL url = new URL(path);
      BufferedImage image = ImageIO.read(url);
      jPanel.add(new JLabel(new ImageIcon(image)));
    }
    jPanel.add(new JLabel(String.format("%s %s", "Like count: ", likes)));

    add(jPanel);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

  }
}
