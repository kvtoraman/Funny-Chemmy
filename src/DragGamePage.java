
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DragGamePage {
 
	public DragGamePage() {
		
		//testing DragGame
		
		JFrame game = new JFrame("DRAG GAME!");
		game.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		game.setBounds(100, 100, 1000, 400);
		JPanel menuBarPanel = new JPanel();
		menuBarPanel.setBounds(0, 0, 558, 15);
		menuBarPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		menuBarPanel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		menuBar.add(mnNewMenu);
		
		JMenuItem mnýtmSeeMyProfile = new JMenuItem("See my profile");
		mnýtmSeeMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JDialog.setDefaultLookAndFeelDecorated(true);
				 String str =  "Your Name : " + RunProject.currentUser.getName();
				 ResultSet rs;
				 rs =  Connector.getConditionalStringResult("noOfCorrect", "user", "userName" ,RunProject.currentUser.getName());
				 try {
					str += "\nCorrect Answers : "+ Connector.showConditionalData(rs, "noOfCorrect");
					rs =  Connector.getConditionalStringResult("noOfWrong", "user", "userName" ,RunProject.currentUser.getName());
					str += "\nWrong Answers : "+ Connector.showConditionalData(rs, "noOfWrong");
				} catch (SQLException e) {
	
					e.printStackTrace();
				}
				 JOptionPane.showMessageDialog(null,str,"Profile Information", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu.add(mnýtmSeeMyProfile);
		JMenuItem mnýtmBack = new JMenuItem("Back");
		mnýtmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				game.dispose();
				Menu menu = new Menu();
			}
		});
		mnNewMenu.add(mnýtmBack);
		
		JMenuItem mnýtmLogOut = new JMenuItem("Log out");
		mnýtmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(RunProject.currentUser);
				 JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.NO_OPTION) {
				      System.out.println("No button clicked");
				    } else if (response == JOptionPane.YES_OPTION) {
				      System.out.println("Yes button clicked");
				      RunProject.currentUser.setName(""); 
				      game.dispose();
				      StartPage sPage = new StartPage();
				      System.out.println(RunProject.currentUser);
			
				    } 
			}
		});
		mnNewMenu.add(mnýtmLogOut);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mnýtmGetHelp = new JMenuItem("Get Help");
		mnýtmGetHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("esdd");
				JOptionPane.showMessageDialog(game, "Welcome to drag game!\n "
					+ "Left click elements on thie left and then drop them to to play field (which is on the right)\n"
					+ "The elements which are near will make a bound(if they can) and compose a new compound\n"
					+ "Hope you enjoy!");
			}
		});
		mnHelp.add(mnýtmGetHelp);
		    
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.getContentPane().add("Center",new DragGamePanel());
		game.getContentPane().add("North", menuBarPanel);
		
		game.pack();
		game.setVisible(true);
		
		//testing element commpound classes...
		
		
	/*	Reader oku = new Reader("test.txt");
		Element elements[] = oku.getElements();
		Compound c;
		for(int i = 0 ;i < 20 ;i++){
		
			System.out.println(elements[i].toString());
		
		}*/
		
		
		
		
		
		
	}
}