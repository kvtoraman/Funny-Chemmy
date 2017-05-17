import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Line extends JPanel
{
  int x1;
  int x2;
  int y1;
  int y2;
  
  public Line(int currntX1, int currntX2, int currntY1, int currntY2)
  {
    x1 = currntX1;
    x2 = currntX2;
    y1 = currntY1;
    y2 = currntY2;
  }
  public int getX1coordinate()
  {
   return x1; 
  }
}

