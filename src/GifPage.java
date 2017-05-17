import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JList;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;


public class GifPage {

	private JFrame frmMoreFun;
	DefaultListModel<String> model;
	GifList gifs = new GifList();
	JList<String> list;
	ImageIcon gifImage;
	JLabel imageLabel;
	JLabel background;
	
	public GifPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frmMoreFun = new JFrame();
		frmMoreFun.setResizable(false);
		frmMoreFun.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		frmMoreFun.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		frmMoreFun.setTitle("MORE FUN");
		frmMoreFun.setBounds(100, 100, 900, 500);
		frmMoreFun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
	
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		model = new DefaultListModel<String>();
	    list = new JList<String>(model);
	    UpdateJList();
	    ListSelectionListener listSelectionListener = new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				for(Gif g : gifs.giflist)
				{
					if(list.getSelectedValue().toString().equals(g.getName()))
					{
						gifImage = new ImageIcon(g.url);
						imageLabel.setIcon(gifImage);
					}
				}				
			}
		};
	    list.addListSelectionListener(listSelectionListener);
	    panel.add(list);

		imageLabel = new JLabel();
		panel.add(imageLabel);
		
	//	background=new JLabel(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\frame blank board.png"));
	//	background.setLayout(null);
		
	//	background.add(imageLabel);
	//	panel.add(background);
		JPanel menuBarPanel = new JPanel();
		menuBarPanel.setBounds(0, 0, 558, 15);
		frmMoreFun.getContentPane().add(menuBarPanel);
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
				frmMoreFun.dispose();
				FunPart funPart = new FunPart();
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
				      frmMoreFun.dispose();
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
				JOptionPane.showMessageDialog(null, "Welcome to Funny Part!\n"
					+ "Choose experiment from menulist which you want to watch\n"
					+ "Hope you enjoy!");
			}
		});
		mnHelp.add(mnýtmGetHelp);
		
		frmMoreFun.getContentPane().add("Center",panel);
		frmMoreFun.getContentPane().add("North",menuBarPanel);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMoreFun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	    }		
		
		private void UpdateJList(){
			model = new DefaultListModel<String>();
			for(Gif p : gifs.giflist){
				model.addElement(p.getName());
			}    
			list.setModel(model);     
			list.setSelectedIndex(0);
	}
}
