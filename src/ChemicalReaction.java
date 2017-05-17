import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;


public class ChemicalReaction {
	Reaction[] reactionList = new Reaction[5];
	JButton btnNeutralization ;
	JButton btnCombustion;
	JButton btnAcidBase;
	JButton btnDisplacement;
	JButton btnSynthesis;
	ResultSet rs;
	
	protected JFrame reactionFrame;
	
	public ChemicalReaction() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		try{
		rs = Connector.getConditionalStringResult("reactionInfo", "reactions", "reactionType", "Neutralization");
		reactionList[0] = new Reaction("Neutralization",Connector.showConditionalData(rs, "reactionInfo"));
		
		rs = Connector.getConditionalStringResult("reactionInfo", "reactions", "reactionType", "Combustion");
		reactionList[1] = new Reaction("Combustion",Connector.showConditionalData(rs, "reactionInfo"));
		
		rs = Connector.getConditionalStringResult("reactionInfo", "reactions", "reactionType", "Displacement");
		reactionList[2] = new Reaction("Displacement",Connector.showConditionalData(rs, "reactionInfo"));
		
		rs = Connector.getConditionalStringResult("reactionInfo", "reactions", "reactionType", "AcidBase");
		reactionList[3] =  new Reaction("AcidBase",Connector.showConditionalData(rs, "reactionInfo"));
		
		rs = Connector.getConditionalStringResult("reactionInfo", "reactions", "reactionType", "Synthesis");
		reactionList[4] =  new Reaction("Sytnhesis",Connector.showConditionalData(rs, "reactionInfo"));
		
		}catch(Exception e){
			e.printStackTrace();
		}
			
		reactionFrame = new JFrame();
		reactionFrame.setResizable(false);
		reactionFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		reactionFrame.setTitle("CHEMICAL REACTIONS");
		reactionFrame.setBounds(100, 100, 1000, 600);
		reactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Menu.png"));
		background.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(200, 150, 580, 300);
		background.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(5,1));
		
		btnNeutralization = new JButton("");
		btnNeutralization.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Neutralization button.png"));
		btnNeutralization.setToolTipText("Click for info");
		btnNeutralization.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		btnNeutralization.addActionListener(new ButtonListener());
		buttonPanel.add(btnNeutralization, BorderLayout.NORTH);
		
		btnCombustion = new JButton("");
		btnCombustion.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Combustion button.png"));
		btnCombustion.setFont(new Font("Buxton Sketch", Font.PLAIN, 15));
		btnCombustion.setToolTipText("Click for info");
		btnCombustion.addActionListener(new ButtonListener());
		buttonPanel.add(btnCombustion, BorderLayout.WEST);
		
		btnAcidBase = new JButton("");
		btnAcidBase.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\acid base button.png"));
		btnAcidBase.setFont(new Font("Buxton Sketch", Font.PLAIN, 15));
		btnAcidBase.setToolTipText("Click for info");
		btnAcidBase.addActionListener(new ButtonListener());
		buttonPanel.add(btnAcidBase, BorderLayout.CENTER);
		
		btnDisplacement = new JButton("");
		btnDisplacement.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\displacement button.png"));
		btnDisplacement.setFont(new Font("Buxton Sketch", Font.PLAIN, 15));
		btnDisplacement.setToolTipText("Click for info");
		btnDisplacement.addActionListener(new ButtonListener());
		buttonPanel.add(btnDisplacement, BorderLayout.EAST);
		
		btnSynthesis = new JButton("");
		btnSynthesis.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Synthesis button.png"));
		btnSynthesis.setFont(new Font("Buxton Sketch", Font.PLAIN, 15));
		btnSynthesis.setToolTipText("Click for info");
		btnSynthesis.addActionListener(new ButtonListener());
		buttonPanel.add(btnSynthesis, BorderLayout.SOUTH);

		JPanel menuBarPanel = new JPanel();
		menuBarPanel.setBounds(0, 0, 1000, 15);
		reactionFrame.getContentPane().add(menuBarPanel);
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
				reactionFrame.dispose();
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
				      reactionFrame.dispose();
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
				JOptionPane.showMessageDialog(null, "Welcome to Chemical Reactions!\n "
					+ "Click on button which reaction will you want want to get information. \n"
					+ "Hope you enjoy!");
			}
		});
		mnHelp.add(mnýtmGetHelp);
		reactionFrame.getContentPane().add(background);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reactionFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnNeutralization){
				reactionFrame.dispose();
				ReactionInfo info = new ReactionInfo(reactionList[0].getType(),reactionList[0].getReactionData());
			}
			else if(e.getSource() == btnCombustion){
				reactionFrame.dispose();
				ReactionInfo info = new ReactionInfo(reactionList[1].getType(),reactionList[1].getReactionData());
			}
			else if(e.getSource() == btnDisplacement){
				reactionFrame.dispose();
				ReactionInfo info = new ReactionInfo(reactionList[2].getType(),reactionList[2].getReactionData());
			}
			else if(e.getSource() == btnAcidBase){
				reactionFrame.dispose();
				ReactionInfo info = new ReactionInfo(reactionList[3].getType(),reactionList[3].getReactionData());
			}
			else if(e.getSource() == btnSynthesis){
				reactionFrame.dispose();
				ReactionInfo info = new ReactionInfo(reactionList[4].getType(),reactionList[4].getReactionData());
			}
			
		}
		
	}
}
