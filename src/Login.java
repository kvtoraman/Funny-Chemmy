import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Window.Type;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Toolkit;


public class Login {

	private JFrame loginFrame;
	private JTextField nameField;
	private JPasswordField passwordField;
	User current;
	Users list = new Users();

	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
		loginFrame = new JFrame();
		loginFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		loginFrame.setResizable(false);
		loginFrame.getContentPane().setBackground(new Color(245, 255, 250));
		loginFrame.getContentPane().setForeground(Color.WHITE);
		loginFrame.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		loginFrame.setTitle("LOGIN");
		loginFrame.setBounds(100, 100, 524, 366);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(0, 128, 128));
		loginPanel.setBounds(52, 47, 430, 232);
		loginFrame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBackground(UIManager.getColor("TextField.light"));
		nameField.setToolTipText("Enter your name");
		nameField.setBounds(156, 29, 200, 34);
		loginPanel.add(nameField);
		nameField.setText("");
		nameField.setColumns(10);
				
		passwordField = new JPasswordField();
		passwordField.setBackground(UIManager.getColor("TextField.light"));
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(156, 89, 200, 35);
		loginPanel.add(passwordField);
		passwordField.setText("");
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setBackground(new Color(255, 250, 240));
		nameLabel.setForeground(new Color(255, 250, 240));
		nameLabel.setBounds(32, 23, 114, 64);
		loginPanel.add(nameLabel);
		nameLabel.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		
		JLabel passLabel = new JLabel("Password : ");
		passLabel.setForeground(new Color(255, 250, 240));
		passLabel.setBounds(32, 88, 200, 34);
		loginPanel.add(passLabel);
		passLabel.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(0, 128, 128));
		btnBack.setBackground(UIManager.getColor("Button.darkShadow"));
		btnBack.setBounds(77, 163, 136, 45);
		loginPanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginFrame.dispose();
				StartPage startPg = new StartPage();
			}
		});
		btnBack.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 128, 128));
		btnLogin.setBackground(UIManager.getColor("Button.darkShadow"));
		btnLogin.setBounds(239, 163, 136, 45);
		loginPanel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = nameField.getText();
				String pass = passwordField.getText();
				if(!name.equals("") && !pass.equals(""))
				{

					int count = 0;					
					for(int i = 0;i<list.numOfUsers; i++)
					{
						if(name.equals(list.userlist.get(i).name) && pass.equals(list.userlist.get(i).password))
								count = 1;
					}
//					ResultSet rs = Connector.verifyUser("userName", "userPassword", "user", name, pass);
//					try {
//						while(rs.next()){
//							count++;
//						}
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					if(count == 1){
						
						JOptionPane.showMessageDialog(null,"User is found!");
						loginFrame.dispose();
						RunProject.currentUser.setName(name);
						Menu menu = new Menu();
						//System.out.println(RunProject.currentUser);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"User is NOT found!");
						nameField.setText("");
						passwordField.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"FILL ALL FIELDS!");
					nameField.setText("");
					passwordField.setText("");
				}
				
				
			}
		}
		);
		btnLogin.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
