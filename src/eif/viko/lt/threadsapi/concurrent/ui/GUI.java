package eif.viko.lt.threadsapi.concurrent.ui;

import eif.viko.lt.threadsapi.concurrent.domain.Exhibit;
import eif.viko.lt.threadsapi.concurrent.domain.ExhibitOption;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GUI extends JFrame {

  private final Map<String, ImageIcon> imageMap;

  public GUI(Exhibit exhibit) throws IOException {
    List<ExhibitOption> exhibitOptionList = exhibit.getExhibitInfo().getExhibitOptionList();
    long likes = exhibit.getExhibitRating().getLikeCount();
    imageMap = new HashMap<>();
    for (ExhibitOption e : exhibitOptionList) {
      imageMap.put(e.getName(), new ImageIcon(e.getImageURL()));
    }
    JList<Object> list = new JList<>(imageMap.keySet().toArray());
    list.setCellRenderer(new ExhibitListRenderer());
    JScrollPane scrollPane = new JScrollPane(list);
    scrollPane.setPreferredSize(new Dimension(800, 600));

    add(scrollPane);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private class ExhibitListRenderer extends DefaultListCellRenderer {
    Font font = new Font("helvitica", Font.BOLD, 24);

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

      JLabel jLabel = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
      // Custom List item label
      jLabel.setIcon(imageMap.get(value));
      jLabel.setHorizontalTextPosition(JLabel.RIGHT);
      jLabel.setFont(font);

      return jLabel;
    }

  }
}
