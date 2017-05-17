import java.awt.*;
import java.awt.event.*;
import java.text.AttributedString;
import java.util.Random;
import java.awt.font.TextAttribute;

import javax.swing.*;

public class PlayPanel extends JPanel {
	DragGame table;
	int mouseX = 0;
	int mouseY = 0;
	final int EDGE_SIZE = 20;
	boolean printElement = false;
	Element moving;

	Color col[] = new Color[20];
	
	public PlayPanel(){
		Random rand = new Random();
		for(int i = 0; i < 20; i++)
			col[i] = new Color(rand.nextInt(216) + 20, rand.nextInt(216) + 20, rand.nextInt(216) + 20);
		
		table = new DragGame();
		moving = new Element();
		setPreferredSize( new Dimension( 800, 600));
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.BLUE);
		if(printElement){
			g.drawString(moving.symbol, mouseX, mouseY);
			g.fillRect(mouseX,mouseY,EDGE_SIZE,EDGE_SIZE);
		}
		
		
		for(int i = 0; i < table.destElements.size(); i++){
			Element e = table.destElements.get(i);
			g.setColor(col[e.atomNo - 1]);
			g.fillRect(e.x,e.y,EDGE_SIZE,EDGE_SIZE);
			
			g.setColor(Color.black);
			g.drawString(e.symbol, e.x, e.y+EDGE_SIZE);
		}		
		//g.setFont();
		for(Compound c: table.compound){
			g.setColor(Color.black);
			g.drawString(c.FancyString().getIterator(),c.x,c.y);
		}
		//System.out.println("" + mouseX + " " + mouseY);
			
	}
}
