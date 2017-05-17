
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;


public class InformationPanel extends Panel implements MouseListener
{
  private int X = 0;
  private int Y = 0;
  private Element[] es;
  private TextArea textArea;
  
  public InformationPanel(int ElementS)
  {
	   
    setBackground(Color.white);
    textArea = new TextArea("", 5, 50, TextArea.SCROLLBARS_NONE);
    textArea.setBackground(Color.white);
    textArea.setForeground(Color.black);
    textArea.setEditable(false);
    add(textArea);
  
    es = new Element[ElementS];
    
    es[0] = new Element("Hydrogen", 1, "H", 1.01);
    es[1] = new Element("Lithium", 3, "Li", 6.941);
    es[2] = new Element("Sodium", 11, "Na", 22.99);
    es[3] = new Element("Potassium", 19, "K", 39.10);
    es[4] = new Element("Rubidium", 37, "Rb", 85.47);
    es[5] = new Element("Caesium", 55, "Cs", 132.90);
    es[6] = new Element("Francium", 87, "Fr", 223.00);
    
    es[7] = new Element("Beryllium", 4, "Be", 9.012);
    es[8] = new Element("Magnesium", 12, "Mg", 24.31);
    es[9] = new Element("Calcium", 20, "Ca", 40.08);
    es[10] = new Element("Strontium", 38, "Sr", 87.62);
    es[11] = new Element("Barium", 56, "Ba",137.30);
    es[12] = new Element("Radium", 88, "Ra", 226.00);
    
    es[13] = new Element("Scandium", 21, "Sc", 44.96);
    es[14] = new Element("Yttrium", 39, "Y", 88.91);
    es[15] = new Element("Lutetium", 71, "Lu", 174.97);
    es[16] = new Element("Lawrencium", 103, "Lr", 262.00);
    
    es[17] = new Element("Titanium", 22, "Ti", 47.87);
    es[18] = new Element("Zirconium", 40, "Zr", 91.22);
    es[19] = new Element("Hafnium", 72, "Hf", 178.49);
    es[20] = new Element("Rutherfordium", 104, "Rf", 261.00);
    
    es[21] = new Element("Vanadium", 23, "V", 50.94);
    es[22] = new Element("Niobium", 41, "Nb", 92.91);
    es[23] = new Element("Tantalum", 73, "Ta", 180.95);
    es[24] = new Element("Dubnium", 105, "Db", 262.00);
    
    es[25] = new Element("Chromium", 24, "Cr", 51.996);
    es[26] = new Element("Molybdenum", 42, "Mo", 95.94);
    es[27] = new Element("Tungsten", 74, "W", 183.84);
    es[28] = new Element("Seaborgium", 106, "Sg", 263.00);
    
    es[29] = new Element("Manganese", 25, "Mn", 54.94);
    es[30] = new Element("Technetium", 43, "Tc", 98.00);
    es[31] = new Element("Rhenium", 75, "Re", 186.21);
    es[32] = new Element("Bohrium", 107, "Bh", 262.00);
    
    es[33] = new Element("Iron", 26, "Fe", 55.85);
    es[34] = new Element("Ruthenium", 44, "Ru", 101.07);
    es[35] = new Element("Osmium", 76, "Os", 190.23);
    es[36] = new Element("Hassium", 108, "Hs", 265.00);
    
    es[37] = new Element("Cobalt", 27, "Co", 58.93);
    es[38] = new Element("Rhodium", 45, "Rh", 102.91);
    es[39] = new Element("Iridium", 77, "Ir", 192.22);
    es[40] = new Element("Meitnerium", 109, "Mt", 266.00);
    
    es[41] = new Element("Nickel", 28, "Ni", 58.69);
    es[42] = new Element("Palladium", 46, "Pd", 106.42);
    es[43] = new Element("Platinum", 78, "Pt", 195.08);
    es[44] = new Element("Ununnilium", 110, "Uun", 269.00);
    
    es[45] = new Element("Copper", 29, "Cu", 63.55);
    es[46] = new Element("Silver", 47, "Ag", 107.87);
    es[47] = new Element("Gold", 79, "Au", 196.97);
    es[48] = new Element("Unununium", 111, "Uuu", 272.00);
    
    es[49] = new Element("Zinc", 30, "Zn", 65.39);
    es[50] = new Element("Cadmium", 48, "Cd", 112.41);
    es[51] = new Element("Mercury", 80, "Hg", 200.59);
    es[52] = new Element("Ununbium", 112, "Uub", 277.00);
    
    es[53] = new Element("Boron", 5, "B", 10.81);
    es[54] = new Element("Aluminum", 13, "Al", 26.98);
    es[55] = new Element("Gallium",31, "Ga", 69.72);
    es[56] = new Element("Indium", 49, "In", 114.82);
    es[57] = new Element("Thallium", 81, "Tl", 204.38);
    es[58] = new Element("Ununtrium", 113, "Uut", 000);
    
    es[59] = new Element("Carbon", 6, "C", 12.01);
    es[60] = new Element("Silicon", 14, "Si", 28.09);
    es[61] = new Element("Germanium", 32, "Ge", 72.61);
    es[62] = new Element("Tin", 50, "Sn", 118.71);
    es[63] = new Element("Lead", 82, "Pb", 207.2);
    es[64] = new Element("Ununquadium", 114, "Uuq", 285.00);
    
    es[65] = new Element("Nitrogen", 7, "N", 14.01);
    es[66] = new Element("Phosphorus", 15, "P", 30.97);
    es[67] = new Element("Arsenic", 33, "As", 74.92);
    es[68] = new Element("Antimony", 51, "Sb", 121.76);
    es[69] = new Element("Bismuth", 83, "Bi", 208.98);
    es[70] = new Element("?", 115, "Uup", 000);
    
    es[71] = new Element("Oxygen", 8, "O", 15.999);
    es[72] = new Element("Sulfur", 16, "S", 32.07);
    es[73] = new Element("Selenium", 34, "Se", 78.96);
    es[74] = new Element("Tellurium", 52, "Te", 127.60);
    es[75] = new Element("Polonium", 84, "Po", 209.00);
    es[76] = new Element("Ununhexium", 116, "Uuh", 289.00);
    
    es[77] = new Element("Flourine", 9, "F", 18.998);
    es[78] = new Element("Chlorine", 17, "Cl", 35.45);
    es[79] = new Element("Bromine", 35, "Br", 79.90);
    es[80] = new Element("Iodine", 53, "I", 126.90);
    es[81] = new Element("Astatine", 85, "At", 210.00);
    es[82] = new Element("?", 117, "Uus", 000);
    
    es[83] = new Element("Helium", 2, "He", 4.003);
    es[84] = new Element("Neon", 10, "Ne", 20.18);
    es[85] = new Element("Argon", 18, "Ar", 39.95);
    es[86] = new Element("Krypton", 36, "Kr", 83.80);
    es[87] = new Element("Xenon", 54, "Xe", 131.29);
    es[88] = new Element("Radon", 86, "Rn", 222.00);
    es[89] = new Element("Ununoctium", 118, "Uuo", 293.00);   
    es[90] = new Element("Lanthanum", 57, "La", 138.91);
    es[91] = new Element("Actinium", 89, "Ac", 227.03);
    es[92] = new Element("Cerium", 58, "Ce", 140.116);
    es[93] = new Element("Thorium", 90, "Th", 232.04);
    es[94] = new Element("Praseodymium", 59, "Pr", 140.91);
    es[95] = new Element("Protactinium", 91, "Pa", 231.06);
    es[96] = new Element("Neodymium", 60, "Nd", 144.24);
    es[97] = new Element("Uranium", 92, "U", 238.03);
    es[98] = new Element("Promethium", 61, "Pm", 145.00);
    es[99] = new Element("Neptunium", 93, "Np", 237.00);
    es[100] = new Element("Samarium", 62, "Sm", 150.36);
    es[101] = new Element("Plutonium", 94, "Pu", 244.00);
    es[102] = new Element("Europium", 63, "Eu", 151.96);
    es[103] = new Element("Americium", 95, "Am", 243.00);
    es[104] = new Element("Gadolinium", 64, "Gd", 157.25);
    es[105] = new Element("Curium", 96, "Cm", 247.00);
    es[106] = new Element("Terbium", 65, "Tb", 158.93);
    es[107] = new Element("Berkelium",97, "Bk", 247.00);
    es[108] = new Element("Dysprosium", 66, "Dy", 162.50);
    es[109] = new Element("Californium", 98, "Cf", 251.00);
    es[110] = new Element("Holmium", 67, "Ho", 164.93);
    es[111] = new Element("Einsteinium", 99, "Es", 252.00);
    es[112] = new Element("Erbium", 68, "Er", 167.26);
    es[113] = new Element("Fermium", 100, "Fm", 257.00);
    es[114] = new Element("Thulium", 69, "Tm", 168.93);
    es[115] = new Element("Mendelvium", 101, "Md", 258.00);
    es[116] = new Element("Ytterbium", 70, "Yb", 173.04);
    es[117] = new Element("Nobelium", 102, "No", 259.00);
  }
  
  public void setCoords(int x, int y, Point [] Map, int mapsize, int recW, int recH)
  {
    X = x;
    Y = y;
    int p = 0;
    Point P = new Point();
    Boolean set = Boolean.FALSE;
    
    for(int i = 0; i < mapsize; i++)
    {
      if(i <= 13)
      {
        p = i;
      }
      else if(i >= 14 && i <= 22)
      {
        p = i + 3 * (i % 13);
      }
      else if(i >= 23 && i <= 32)
      {
        p = i - 9 + 4 * (i % 23) - 1 * (i % 23);
      }
      else if(i >= 33 && i <= 42)
      {
        p = i - 18 + 4 * (i % 33) - 1 * (i % 33);
      }
      else if(i >= 43 && i <= 52)
      {
        p = i - 27 + 4 * (i % 43) - 1 * (i % 43);
      }
      else if(i >= 53 && i <= 57)
      {
        p = i + 5 * (i % 53);
      }
      else if(i >= 58 && i <= 62)
      {
        p = i - 4 + 6 * (i % 58) - 1 * (i % 58);
      }
      else if(i >= 63 && i <= 67)
      {
        p = i - 8 + 6 * (i % 63) - 1 * (i % 63);
      }
      else if(i >= 68 && i <= 72)
      {
        p = i - 12 + 6 * (i % 68) - 1 * (i % 68);
      }
      else if(i >= 73 && i <= 77)
      {
        p = i - 16 + 6 * (i % 73) - 1 * (i % 73);
      }
      else if(i >= 78 && i <= 82)
      {
        p = i - 20 + 6 * (i % 78) - 1 * (i % 78);
      }
      else if(i >= 83 && i <= 89)
      {
        p = i;
      }
      else if(i >= 90 && i <= 103)
      {
        p =  i + 1 * (i % 90);
      }
      else if(i >= 104 && i <= 117)
      {
        p = i - 13 + 2 * (i % 104) - 1 * (i % 104);
      }
      if(X >= Map[i].x && X <= (Map[i].x + recW) && Y >= Map[i].y && Y <= (Map[i].y + recH))
      {
        set = Boolean.TRUE;
        if(!textArea.getText().equals(es[p].getDescription()))
        {
          textArea.setText(es[p].getDescription());
        }
        else
        {
          break;
        }
      }
    }
    
    if(!set.booleanValue())
    {
      if(!textArea.getText().equals(""))
      {
        textArea.setText("");
      }
    }
  }
  
  public void mouseEntered(MouseEvent e){}
  public void mouseExited(MouseEvent e){}
  public void mouseClicked(MouseEvent e){}
  public void mousePressed(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
  
}