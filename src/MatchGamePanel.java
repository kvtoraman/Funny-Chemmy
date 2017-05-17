import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class MatchGamePanel extends JPanel
{
  JButton elementButtons[] = new JButton[5];
  JButton atomNumberButtons[] = new JButton[5];
  
  JButton currentElementButton;
  JButton currentAtomNumberButton;
  
  JButton testButton1;
  JButton testButton2;
  
  JPanel comboPanel;
  
  Random  generator1;
  static int count = 0;
  Color[] col  = new Color[5];
  
  final int EDGE_SIZE = 30;
  MatchGame matchGame;
  ArrayList<Line> lines;
 
  public MatchGamePanel()
  {  
    matchGame = new MatchGame();
    
    lines = new ArrayList<Line>();
    
    setPreferredSize( new Dimension( 800, 600));

    setLayout( null);
        
    int elementRandom;
    col[ 0] = new Color(255,0,0);
    col[ 1] = new Color(0,255,0);
    col[ 2] = new Color(0,0,255);
    col[ 3] = new Color(255,255,0);
    col[ 4] = new Color(0,255,255);
    
    
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    //elements are numbered from 0 to 19 in our classes
    for(int k = 0; k <20; k++)
    {
      list.add(k);
    }
    Collections.shuffle(list);
    
    
    for(int i= 0 ; i < 5; i++)
    {
      
      elementButtons[i] = new JButton();
      elementButtons[i].setPreferredSize(new Dimension(100,100));
      elementButtons[i].setBounds(i*100 + 150,0,100,100);
      elementButtons[i].setText(matchGame.allElements.get(list.get(i)).symbol);
      
      elementButtons[i].addActionListener(new ElementButtonListener() );
      
      add(elementButtons[i]);
      
    }
    
    ArrayList<Integer> list2 = new ArrayList<Integer>();

    for(int m = 0; m < 5; m++)
    {
      list2.add(list.get(m));
    }

    Collections.shuffle(list2);
    
    
    for(int i= 0 ; i < 5; i++)
    {
      
      atomNumberButtons[i] = new JButton();
      atomNumberButtons[i].setPreferredSize(new Dimension(100,100));
      atomNumberButtons[i].setText(String.valueOf(matchGame.allElements.get(list2.get(i)).atomNo));
      atomNumberButtons[i].setBounds(i*100 + 150,500,100,100);
      
      atomNumberButtons[i].addActionListener(new AtomNumberButtonListener() );
      
      add(atomNumberButtons[i]);
      
    }

    
  }
  private class ElementButtonListener implements ActionListener
  {  
    public void actionPerformed(ActionEvent e)
    {
      for(int k = 0; k < 5; k++)
      {
        if(elementButtons[k] == e.getSource())
        {
          matchGame.currentSymbol = elementButtons[k].getText();
          matchGame.currentX1 = elementButtons[k].getX() + 50;
          matchGame.currentY1 = elementButtons[k].getY() + 100;
          currentElementButton = elementButtons[k];
          
        }
      }
      for(int m = 0; m < 20; m++)
      {
        if(matchGame.currentSymbol == matchGame.allElements.get(m).symbol)
        {
          matchGame.currentElement = matchGame.allElements.get(m);
        }
      }
    } 
  }
  
  private class AtomNumberButtonListener implements ActionListener
  {  
    public void actionPerformed(ActionEvent e)
    {
      for(int i = 0; i<5;i++)
      {
        if(e.getSource() == atomNumberButtons[i] )
        {
          matchGame.currentAtomNumber = Integer.parseInt(atomNumberButtons[i].getText());
          currentAtomNumberButton = atomNumberButtons[i];
          matchGame.currentX2 = atomNumberButtons[i].getX() + 50;
          matchGame.currentY2 = atomNumberButtons[i].getY() ;
          
        }
      }
      
      if(matchGame.currentElement.atomNo == matchGame.currentAtomNumber)
      {
    	
        JOptionPane.showMessageDialog (null, "You know it. Continue!", "Good!", JOptionPane.INFORMATION_MESSAGE);
        
        currentElementButton.setBackground(col[ lines.size() ]);  
        currentAtomNumberButton.setBackground(col[ lines.size() ]);  
    	
        currentElementButton.setEnabled(false);
        currentAtomNumberButton.setEnabled(false);
        count++;
        
        Line line = new Line(matchGame.currentX1,matchGame.currentX2,matchGame.currentY1,matchGame.currentY2);
        
        lines.add(line);
        
        repaint();
        if(MatchGamePanel.count == 5){
        	JOptionPane.showMessageDialog(null,"CONGRATULATIONS!\nCLICK BACK TO QUIT MATCH GAME!");
        }
      }
      else
      {
        JOptionPane.showMessageDialog (null, "You did not know it. Try again!", "Mistake!", JOptionPane.INFORMATION_MESSAGE);
        repaint();
      }
    }
  }
  @Override
  public void paintComponent(Graphics page)
  {
    super.paintComponent(page);
    
    
    
    for(int i = 0; i < lines.size(); i++)
    {
    //change color to ith color
      page.setColor( col[ i]);
      page.drawLine(lines.get(i).x1 , lines.get(i).y1 , lines.get(i).x2 , lines.get(i).y2);
    }  
    
  }
}



