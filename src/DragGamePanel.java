import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class DragGamePanel extends JPanel {
	JButton b[] = new JButton[20];
	Element moved;
	JPanel buttonPanel;
	PlayPanel playPanel;
	final int EDGE_SIZE = 20;
	
	public DragGamePanel(){
		
		setPreferredSize( new Dimension( 1000, 400));
		setLayout( new BoxLayout( this, BoxLayout.X_AXIS ));
		
		
		buttonPanel= new JPanel();
		playPanel = new PlayPanel();
		playPanel.addMouseListener(new Listener());
		playPanel.addMouseMotionListener(new Listener());
		
		buttonPanel.setLayout( new GridLayout( 5, 4));
		buttonPanel.setPreferredSize(new Dimension(400,500));
		for(int i= 0 ; i < 20; i++){
			b[i] = new JButton();
			
			//Getters & Setters
			b[i].setText(playPanel.table.allElements.get(i).symbol);
			b[i].setBackground(playPanel.col[i]);
			b[i].addActionListener(new ButtonListener() );
			buttonPanel.add( b[i]);
		}
		
		add(buttonPanel);
		add(playPanel);
		
		
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	
	}
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			for(int i = 0; i<20;i++)
				if(b[i] == e.getSource()){
					moved = new Element(playPanel.table.allElements.get(i));
					//moved = playPanel.table.allElements.get(i);
					playPanel.moving = moved;
					playPanel.printElement = true;
				}
			
		}
	}
	private class Listener implements MouseListener,MouseMotionListener{
		
		public void mouseMoved(MouseEvent event) {
			playPanel.mouseX = event.getX();
			playPanel.mouseY = event.getY();
			repaint();
		}
		public void mouseClicked(MouseEvent event){
			
			moved.x = event.getX();
			moved.y = event.getY();
			
			if(playPanel.printElement == false)
				return;
			if(playPanel.table.compareDistance(moved)){
				repaint();
				return ;
			}
			
			playPanel.table.destElements.add( moved);
			//System.out.println(moved.x  + " " + moved.y);
			playPanel.printElement = false;
			
			//System.out.println("Total Elements" + playPanel.table.destElements.size());
			//System.out.println("Total Compound" + playPanel.table.compound.size());
			
			
			
			repaint();
		}
		
		public void mouseDragged(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		
		
		
	}
}
