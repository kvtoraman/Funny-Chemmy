
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class PeriodicTable extends Applet
{
  private PeriodicTableGui periodicTableGui;
  private InformationPanel informationPanel;
  private final int ELEMENTS = 118;

public void init()
  {
    setLayout(new BorderLayout());
    informationPanel = new InformationPanel(ELEMENTS);
    periodicTableGui = new PeriodicTableGui(informationPanel, ELEMENTS);
    add("Center", periodicTableGui);
    add("South", informationPanel);
  }
}