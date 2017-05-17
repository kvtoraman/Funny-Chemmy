import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;


public class Menu {

	private JFrame menuFrame;

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		menuFrame = new JFrame();
		menuFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		menuFrame.setTitle("MENU");
		menuFrame.setBounds(100, 100, 1000, 600);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.setResizable(false);
		
		
		
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Menu.png"));
		background.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(300, 116, 374, 365);
		background.add(menuPanel);
		GridLayout gl_menuPanel = new GridLayout(4,4);
		menuPanel.setLayout(gl_menuPanel);
		
		JButton btnPrdcTbl = new JButton("");
		btnPrdcTbl.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\periodic table button.png"));
		btnPrdcTbl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFrame.dispose();
				PeriodicTablePage ptp = new PeriodicTablePage();
				
			}
		});
		menuPanel.add(btnPrdcTbl);
		btnPrdcTbl.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		
		JButton btnChmclBnds = new JButton("");
		btnChmclBnds.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\chemical bonds button.png"));
		menuPanel.add(btnChmclBnds);
		btnChmclBnds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFrame.dispose();
				DragGamePage dragGame = new DragGamePage();
				//game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			}
		});
		btnChmclBnds.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		
		JButton btnChmclRctns = new JButton("");
		btnChmclRctns.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\chemical reactions button.png"));
		btnChmclRctns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuFrame.dispose();
				ChemicalReaction reactionFrame = new ChemicalReaction();
			}
		});
		menuPanel.add(btnChmclRctns);
		btnChmclRctns.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		
		JButton btnQuiz = new JButton("");
		btnQuiz.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\quiz and fun part button.png"));
		menuPanel.add(btnQuiz);
		btnQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFrame.dispose();
				FunPart funPart = new FunPart();
			}
		});
		btnQuiz.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		
		JPanel menuBarPanel = new JPanel();
		menuBarPanel.setBounds(0, 0, 1000, 15);
		menuFrame.getContentPane().add(menuBarPanel);
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
				      menuFrame.dispose();
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
				JOptionPane.showMessageDialog(null, "Welcome to Funny Chemy!\n"
					+ "-You can see periodic table by clicking Periodic Table button\n"
					+ "-You can play game about chemical bonds by clickin Chemical Bonds button\n"
					+ "-You can get information about chemical reactions by clicking\nChemical Rections button\n"
					+ "-You can take a quiz and watch some experiments by clicking Fun Part button!"
					+ "\n\nEnjoy!");
			}
		});
		mnHelp.add(mnýtmGetHelp);
		menuFrame.getContentPane().add(background);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
