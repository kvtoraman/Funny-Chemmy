
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PeriodicTablePage
{ 
	public PeriodicTablePage(){
    JFrame game = new JFrame("PERIODIC TABLE");
    game.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
    game.setPreferredSize( new Dimension(1000,700));
    PeriodicTable periodicTable = new PeriodicTable();
    
    JButton btnBack = new JButton("Back");
    btnBack.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			game.dispose();
			Menu menu = new Menu();
		}
    	
    });
    
    JButton btnGame = new JButton("Start Practice");
    btnGame.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			game.dispose();
			MatchGamePage game = new MatchGamePage();
		}
    	
    });
    
    JPanel menuBarPanel = new JPanel();
	menuBarPanel.setBounds(0, 0, 558, 15);
	menuBarPanel.setLayout(new GridLayout(1, 0, 0, 0));
	
	JMenuBar menuBar = new JMenuBar();
	menuBarPanel.add(menuBar);
	
	JMenu mnNewMenu = new JMenu("Home");
	menuBar.add(mnNewMenu);
	
	JMenuItem mn�tmSeeMyProfile = new JMenuItem("See my profile");
	mn�tmSeeMyProfile.addActionListener(new ActionListener() {
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
	mnNewMenu.add(mn�tmSeeMyProfile);
	
	JMenuItem mn�tmBack = new JMenuItem("Back");
	mn�tmBack.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			game.dispose();
			Menu menu = new Menu();
		}
	});
	mnNewMenu.add(mn�tmBack);
	
	JMenuItem mn�tmLogOut = new JMenuItem("Log out");
	mn�tmLogOut.addActionListener(new ActionListener() {
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
	mnNewMenu.add(mn�tmLogOut);
	
	JMenu mnHelp = new JMenu("Help");
	menuBar.add(mnHelp);
	
	JMenuItem mn�tmGetHelp = new JMenuItem("Get Help");
	mn�tmGetHelp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println("esdd");
			JOptionPane.showMessageDialog(null, "Welcome to Periodic Table!\n"
				+ "You can see each elements' information by hovering mouse on each rectangle.\n"
				+ "If you want to understand better you can play little game by clicking\nStart Practice button.\n"
				+ "Hope you enjoy!");
		}
	});
	mnHelp.add(mn�tmGetHelp);
     periodicTable.init();
     periodicTable.start();
   
    game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.getContentPane().add("North",menuBarPanel);
    game.getContentPane().add("Center" , periodicTable);
    game.getContentPane().add("South" , btnGame);
    game.pack();
    game.setVisible(true);    

	}
}