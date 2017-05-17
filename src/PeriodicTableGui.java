
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class PeriodicTableGui extends Panel implements MouseMotionListener, MouseListener
{
  private InformationPanel myTarget;
  private int mpc = 0;
  private final int recH = 40;
  private final int recW = 35;
  
  // Map table.
  
  private Point[] Map;
  
  // Element table.
  
  private String[] ET;
  
  public PeriodicTableGui(InformationPanel myTarget, int ELEMENTS)
  {
	  
    setBackground(new Color(0,128,0));
    addMouseListener(this);
    addMouseMotionListener(this);
    this.myTarget = myTarget;
    mpc = 0;
    Map = new Point[ELEMENTS];
  }
  
  public void paint(Graphics g)
  {
    int xshift = 0;
    int yshift = 50;
    
    mpc = 0;
    ET = new String[7];
    ET[0] = "H";
    ET[1] = "Li";
    ET[2] = "Na";
    ET[3] = "K";
    ET[4] = "Rb";
    ET[5] = "Cs";
    ET[6] = "Fr";
    g.setColor(Color.gray);
    for(int i = 0; i < 7; i++)
    {
      g.drawRect(xshift + 65, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0), recW, recH);
      g.fillRect(xshift + 65, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0), recW, recH);
    }
    for(int i = 0; i < 7; i++)
    {
      g.setColor(Color.black);
      g.setColor(Color.orange);
      g.draw3DRect(xshift + 60,yshift + 30 + i * recH + (i > 0 ? i * 5 : 0), recW, recH, true);
      Point p = new Point(xshift + 60, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0));
      Map[mpc++] = p;
      g.fill3DRect(xshift + 60,yshift + 30 + i * recH + (i > 0 ? i * 5 : 0), recW, recH, true);
      g.setColor(Color.black);
      g.drawString(ET[i],xshift + 65, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2);
    }
    ET = new String[6];
    ET[0] = "Be";
    ET[1] = "Mg";
    ET[2] = "Ca";
    ET[3] = "Sr";
    ET[4] = "Ba";
    ET[5] = "Ra";
    g.setColor(Color.gray);
    for(int i = 0; i < 6; i++)
    {
      g.drawRect(xshift + 70 + recW,yshift + 40 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH);
      g.fillRect(xshift + 70 + recW,yshift + 40 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH);
    }
    for(int i = 0; i < 6; i++)
    {
      g.setColor(new Color(165, 42, 42)); 
      g.draw3DRect(xshift + 65 + recW, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
      Point p = new Point(xshift + 65 + recW, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH);
      Map[mpc++] = p;
      g.fill3DRect(xshift + 65 + recW, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
      g.setColor(Color.black);
      g.drawString(ET[i], xshift + 70 + recW, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2 + recH);
    }
    ET = new String[4 * 10];
    ET[0] = "Sc";
    ET[1] = "Ti";
    ET[2] = "V";
    ET[3] = "Cr";
    ET[4] = "Mn";
    ET[5] = "Fe";
    ET[6] = "Co";
    ET[7] = "Ni";
    ET[8] = "Cu";
    ET[9] = "Zn";
    ET[10] = "Y";
    ET[11] = "Zr";
    ET[12] = "Nb";
    ET[13] = "Mo";
    ET[14] = "Tc";
    ET[15] = "Ru";
    ET[16] = "Rh";
    ET[17] = "Pd";
    ET[18] = "Ag";
    ET[19] = "Cd";
    ET[20] = "Lu";
    ET[21] = "Hf";
    ET[22] = "Ta";
    ET[23] = "W";
    ET[24] = "Re";
    ET[25] = "Os";
    ET[26] = "Ir";
    ET[27] = "Pt";
    ET[28] = "Au";
    ET[29] = "Hg";
    ET[30] = "Lr";
    ET[31] = "Rf";
    ET[32] = "Db";
    ET[33] = "Sg";
    ET[34] = "Bh";
    ET[35] = "Hs";
    ET[36] = "Mt";
    ET[37] = "Uun";
    ET[38] = "Uuu";
    ET[39] = "Uub";
    for(int i = 0; i < 4; i++)
    {
      for(int j = 0; j < 10; j++)
      {
        g.setColor(Color.gray);
        g.drawRect(xshift + 70 + 3 * recW + j * recW + 5 * j, yshift + 50 + i * recH + (i > 0 ? i * 5 : 0) + 3 * recH, recW, recH);
        g.fillRect(xshift + 70 + 3 * recW + j * recW + 5 * j, yshift + 50 + i * recH + (i > 0 ? i * 5 : 0) + 3 * recH, recW, recH);
        g.setColor(new Color(210, 105, 30));
        g.draw3DRect(xshift + 65 + 3 * recW + j * recW + 5 * j, yshift + 45 + i * recH + (i > 0 ? i * 5 : 0) + 3 * recH, recW, recH, true);
        Point p = new Point(xshift + 65 + 3 * recW + j * recW + 5 * j, yshift + 45 + i * recH +(i > 0 ? i * 5 : 0) + 3 * recH);
        Map[mpc++] = p;
        g.fill3DRect(xshift + 65 + 3 * recW + j * recW + 5 * j, yshift + 45 + i * recH + (i > 0 ? i * 5 : 0) + 3 * recH, recW, recH, true);
        g.setColor(Color.black);
        g.drawString(ET[i * 10 + j], xshift + 70 + 3 * recW + j * recW + 5 * j, yshift + 45 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2 + 3 * recH);
      }
    }
    ET = new String[6 * 5];
    ET[0] = "B";
    ET[1] = "C";
    ET[2] = "N";
    ET[3] = "O";
    ET[4] = "F";
    ET[5] = "Al";
    ET[6] = "Si";
    ET[7] = "P";
    ET[8] = "S";
    ET[9] = "Cl";
    ET[10] = "Ga";
    ET[11] = "Ge";
    ET[12] = "As";
    ET[13] = "Se";
    ET[14] = "Br";
    ET[15] = "In";
    ET[16] = "Sn";
    ET[17] = "Sb";
    ET[18] = "Te";
    ET[19] = "I";
    ET[20] = "Tl";
    ET[21] = "Pb";
    ET[22] = "Bi";
    ET[23] = "Po";
    ET[24] = "At";
    ET[25] = "Uut";
    ET[26] = "Uuq";
    ET[27] = "Uup";
    ET[28] = "Uuh";
    ET[29] = "Uus";
    for(int i = 0; i < 6; i++)
    {
      for(int j = 0; j < 5; j++)
      {
        g.setColor(Color.gray);
        g.drawRect(xshift + 85 + 14 * recW + j * recW + 5 * j, yshift + 40 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH);
        g.fillRect(xshift + 85 + 14 * recW + j * recW + 5 * j, yshift + 40 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH);
        g.setColor(new Color(0, 180 + j * 10, 255));
        g.draw3DRect(xshift + 80 + 14 * recW + j * recW + 5 * j, yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
        Point p = new Point(xshift + 80 + 14 * recW + j * recW + 5 * j, yshift + 35 + i * recH + (i > 0 ?
                                                                                                    i * 5 : 0) + recH);
        Map[mpc++] = p;
        g.fill3DRect(xshift + 80 + 14 * recW + j * recW + 5 * j,yshift + 35 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
        g.setColor(Color.black);
        g.drawString(ET[i * 5 + j],xshift + 85 + 14 * recW + j * recW + 5 * j,yshift + 35 + i * recH + (i > 0 ?i * 5 : 0) + recH / 2 + recH);
      }
    }
    ET = new String[7];
    ET[0] = "He";
    ET[1] = "Ne";
    ET[2] = "Ar";
    ET[3] = "Kr";
    ET[4] = "Xe";
    ET[5] = "Rn";
    ET[6] = "Uuo";
    for(int i = 0; i < 7; i++)
    {
      g.setColor(Color.gray);
      g.drawRect(xshift + 75 + 20 * recW,yshift + 35 + i * recH + (i > 0 ? i * 5 : 0), recW, recH);
      g.fillRect(xshift + 75 + 20 * recW,yshift + 35 + i * recH + (i > 0 ? i * 5 : 0), recW, recH);
      g.setColor(new Color(0, 230, 255));
      g.draw3DRect(xshift + 70 + 20 * recW, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0), recW, recH, true);
      
      Point p = new Point(xshift + 70 + 20 * recW, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0));
      Map[mpc++] = p;
      
      g.fill3DRect(xshift + 70 + 20 * recW, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0), recW, recH, true);
      g.setColor(Color.black);
      g.drawString(ET[i], xshift + 75 + 20 * recW, yshift + 30 + i * recH + (i > 0 ? i * 5 : 0) + recH / 2);
    }
    ET = new String[28];
    ET[0] = "La";
    ET[1] = "Ce";
    ET[2] = "Pr";
    ET[3] = "Nd";
    ET[4] = "Pm";
    ET[5] = "Sm";
    ET[6] = "Eu";
    ET[7] = "Gd";
    ET[8] = "Tb";
    ET[9] = "Dy";
    ET[10] = "Ho";
    ET[11] = "Er";
    ET[12] = "Tm";
    ET[13] = "Yb";
    ET[14] = "Ac";
    ET[15] = "Th";
    ET[16] = "Pa";
    ET[17] = "U";
    ET[18] = "Np";
    ET[19] = "Pu";
    ET[20] = "Am";
    ET[21] = "Cm";
    ET[22] = "Bk";
    ET[23] = "Cf";
    ET[24] = "Es";
    ET[25] = "Fm";
    ET[26] = "Md";
    ET[27] = "No";
    for(int i = 0; i < 2; i++)
      for(int j = 0; j < 14; j++)
      {
        g.setColor(Color.gray);
        g.drawRect(xshift + 175 + j * recW + 5 * j,yshift + 310 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH);
        g.fillRect(xshift + 175 + j * recW + 5 * j,yshift + 310 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH);
        if(i == 1)
          g.setColor(new Color(160, 32, 240));
        else
          g.setColor(new Color(110, 105, 30));
          g.draw3DRect(xshift + 170 + j * recW + 5 * j, yshift + 305 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
          Point p = new Point(xshift + 170 + j * recW + 5 * j,yshift + 305 + i * recH + (i > 0 ? i * 5 : 0) + recH);
          Map[mpc++] = p;
          g.fill3DRect(xshift + 170 + j * recW + 5 * j,yshift + 305 + i * recH + (i > 0 ? i * 5 : 0) + recH, recW, recH, true);
          g.setColor(Color.black);
          g.drawString(ET[i * 14 + j],xshift + 175 + j * recW + 5 * j, yshift + 305 + i * recH + (i > 0 ? i * 5 : 0) +recH / 2 + recH);
      
    }
    
    g.setFont(new Font("Times", Font.BOLD, 15));
    g.setColor(Color.black);
    
    g.drawString("Group", 5, 25);
    g.drawString("Period", 5, 60);
    
    for(int i = 0; i < 2; i++)
    {
      g.drawString(i + 1 + "", 70 + (recW + 5) * i, 25);
      g.drawString(i + 1 + "A", 63 + (recW + 5) * i, 43);
    }
    
    for(int i = 2; i < 18; i++)
    {
      g.drawString(i + 1 + "", 95 + (recW + 5) * i, 25);
      if(i <= 6)
      {
        g.drawString(i + 1 + "B", 93 + (recW + 5) * i, 43);
      }
      else if(i == 8)
      {
        g.drawString("8B", 93 + (recW + 5) * i, 43);
      }
      else if(i > 9 && i < 12)
      {
        g.drawString(i - 9 + "B", 93 + (recW + 5) * i, 43);
      }
      else if(i >= 12)
      {
        g.drawString(i - 9 + "A", 93 + (recW + 5) * i, 43);
      }
    }
    
    for(int i = 0; i < 7; i++)
    {
      g.drawString(i + 1 + "", 20, 105 + (recH + 5) * i);
    }
    
    g.drawString("lanthanides", xshift + 70, yshift + 370);
    g.drawString("actinides", xshift + 70, yshift + 410);
  }

  public Point [] getMap()
  {
    return(Map);
  }
  
  public int getMapSize()
  {
    return(mpc);
  }
  
  public void mouseClicked(MouseEvent e)
  {
    e.consume();
    myTarget.setCoords(e.getX(), e.getY(), getMap(), getMapSize(), recW, recH);
  }
  public void mouseMoved(MouseEvent e)
  {
    myTarget.setCoords(e.getX(), e.getY(), getMap(), getMapSize(), recW, recH);
  }
  public void mousePressed(MouseEvent e){} 
  public void mouseReleased(MouseEvent e){}  
  public void mouseDragged(MouseEvent e){}
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  
}