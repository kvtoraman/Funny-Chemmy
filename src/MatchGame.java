//change name of this class
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class MatchGame 
{
  public ArrayList<Element> allElements ;
  
  final int EDGE_SIZE = 30;
  final int BOND_LIMIT = 600;
  
  String currentSymbol;
  Element currentElement;
  int currentX1;
  int currentX2;
  int currentY1;
  int currentY2;
  
 // ArrayList<Line> lines;
  int currentAtomNumber;
  int numberOfmatches;
  int X,Y;
  //MatchGamePanel game;
  public MatchGame()
  { 
   // lines = new ArrayList<Line>();
    currentX1 = 0;
    currentX2 = 0;
    currentY1 = 0;
    currentY2 = 0;
    
    allElements = new ArrayList<Element>();
    X = 0;
    Y = 0 ;
    Reader oku = new Reader("test.txt");
    Element ar[] = oku.getElements();
    
    currentSymbol = "";
    currentElement = null;
    currentAtomNumber = 0;
    numberOfmatches = 0;
    
    //game = new MatchGamePanel();
    for(int i = 0; i < 20; i++)
      allElements.add(ar[i]);
    
    System.out.println("MatchGame created."); 
    //game.initiateTheGame();
  }

  public boolean isGameOver()
  {
    if(numberOfmatches == 5)
    {
      return  true;
    }
    else
    {
      return false;
    }
  }
  public boolean isMatch( Element currentElm, int currentAtomNum)
  {
    if(currentElm.atomNo == currentAtomNum )
    {
      numberOfmatches++;
      return true;
    }
    else
    {
      return false; 
    }      
  }
  public void play()
  {
    while(!isGameOver())
    {
      if(isMatch(currentElement,currentAtomNumber))
      {
        JOptionPane.showMessageDialog (null, "You knew it. Continue!", "Good!", JOptionPane.INFORMATION_MESSAGE);   
      }
      else
      {
        JOptionPane.showMessageDialog (null, "You did not knew it. Try again!", "Mistake!", JOptionPane.INFORMATION_MESSAGE);
      }
    }
  }
}
