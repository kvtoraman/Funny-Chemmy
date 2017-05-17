import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.Border;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Toolkit;


public class FunPart {

	private JFrame funPartFrame;
	/**
	 * Create the application.
	 */
	public FunPart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		Border border = BorderFactory.createCompoundBorder(raisedBevel,loweredBevel);
		
		funPartFrame = new JFrame();
		funPartFrame.setResizable(false);
		funPartFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		funPartFrame.setTitle("FUN PART");
		funPartFrame.setBounds(100, 100, 1000, 600);
		funPartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Menu.png"));
		background.setLayout(null);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setForeground(Color.WHITE);
		buttonPanel.setBounds(220, 220, 515, 182);
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(null);
		buttonPanel.setBorder(border);
		background.add(buttonPanel);

		
		JButton btnQuiz = new JButton("");
		btnQuiz.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Start Quiz button.png"));
		btnQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funPartFrame.dispose();
				StartQuiz quiz = new StartQuiz();
			}
		});
		btnQuiz.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		btnQuiz.setBounds(25, 22, 284, 63);
		buttonPanel.add(btnQuiz);
		
		JButton btnFunPart = new JButton("");
		btnFunPart.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\More Fun Button.png"));
		btnFunPart.setBounds(203, 95, 289, 64);
		buttonPanel.add(btnFunPart);
		btnFunPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				funPartFrame.dispose();
				GifPage gifP = new GifPage();
			}
		});
		btnFunPart.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		
		JPanel menuBarPanel = new JPanel();
		menuBarPanel.setBounds(0, 0, 1000, 15);
		funPartFrame.getContentPane().add(menuBarPanel);
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
				funPartFrame.dispose();
				Menu menu = new Menu();
			}
		});
		mnNewMenu.add(mnýtmBack);
		
		JMenuItem mnýtmLogOut = new JMenuItem("Log out");
		mnýtmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(RunProject.currentUser.getName());
				 JDialog.setDefaultLookAndFeelDecorated(true);
				    int response = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				    if (response == JOptionPane.NO_OPTION) {
				      System.out.println("No button clicked");
				    } else if (response == JOptionPane.YES_OPTION) {
				      System.out.println("Yes button clicked");
				      RunProject.currentUser.setName("");
				      funPartFrame.dispose();
				      StartPage sPage = new StartPage();
				      System.out.println(RunProject.currentUser.getName());
				      
				      
				    } 
			}
		});
		mnNewMenu.add(mnýtmLogOut);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mnýtmGetHelp = new JMenuItem("Get Help");
		mnýtmGetHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Welcome Fun Part!\n"
					+ "Click on Quiz button to take 5 questions quiz.\n"
					+ "Click on More Fun button to watch some experiments.\n"
					+ "Hope you enjoy!");
			}
		});
		mnHelp.add(mnýtmGetHelp);
		funPartFrame.getContentPane().add(background);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					funPartFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
