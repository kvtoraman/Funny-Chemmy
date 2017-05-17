import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MatchGamePage {
	public MatchGamePage(){
    JFrame matchGame = new JFrame("Match Game!");
    
    MatchGamePanel matchGamePanel = new MatchGamePanel();
    
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
			matchGame.dispose();
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
			      matchGame.dispose();
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
			JOptionPane.showMessageDialog(matchGame, "Welcome to Match Game!\n "
				+ "Firstly, click an element's symbol after then click its atom number at the bottom\n"
				+ "If yout choice is true, you will not be able to click the same button again and\nIf "
				+ "your answer is false, you need to try again\n"
				+ "Hope you enjoy!");
		}
	});
	mnHelp.add(mnýtmGetHelp);
	    
	matchGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	matchGame.getContentPane().add("Center",new MatchGamePanel());
	matchGame.getContentPane().add("North", menuBarPanel);
	matchGame.pack();
    matchGame.setVisible(true);
	}
}
