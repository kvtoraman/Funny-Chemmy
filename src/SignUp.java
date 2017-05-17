import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

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
import java.util.ArrayList;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Toolkit;


public class SignUp {

	private JFrame signUpFrame;
	private JTextField nameField;
	private JPasswordField passwordField;
	
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		JFrame.setDefaultLookAndFeelDecorated(true);
		signUpFrame = new JFrame();
		signUpFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		signUpFrame.getContentPane().setBackground(new Color(255, 250, 240));
		signUpFrame.setResizable(false);
		signUpFrame.getContentPane().setForeground(Color.WHITE);
		signUpFrame.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		signUpFrame.setTitle("SIGN UP");
		signUpFrame.setBounds(100, 100, 524, 366);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUpFrame.getContentPane().setLayout(null);
		
		JPanel signUpPanel = new JPanel();
		signUpPanel.setBackground(new Color(0, 128, 128));
		signUpPanel.setBounds(48, 48, 423, 243);
		signUpFrame.getContentPane().add(signUpPanel);
		signUpPanel.setLayout(null);
		
		nameField = new JTextField();
		nameField.setBackground(UIManager.getColor("TextField.light"));
		nameField.setToolTipText("Enter your name");
		nameField.setBounds(164, 27, 200, 34);
		signUpPanel.add(nameField);
		nameField.setText("");
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(UIManager.getColor("TextField.light"));
		passwordField.setToolTipText("Enter your password");
		passwordField.setBounds(164, 93, 200, 34);
		signUpPanel.add(passwordField);
		passwordField.setText("");
		
		JLabel nameLabel = new JLabel("Name :");
		nameLabel.setForeground(new Color(255, 250, 240));
		nameLabel.setBackground(new Color(255, 250, 240));
		nameLabel.setBounds(40, 11, 114, 64);
		signUpPanel.add(nameLabel);
		nameLabel.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		
		JLabel passLabel = new JLabel("Password : ");
		passLabel.setForeground(new Color(255, 250, 240));
		passLabel.setBackground(new Color(255, 250, 240));
		passLabel.setBounds(40, 84, 114, 50);
		signUpPanel.add(passLabel);
		passLabel.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBackground(UIManager.getColor("Button.darkShadow"));
		btnNewButton.setBounds(221, 168, 122, 39);
		signUpPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = nameField.getText();
				String pass = passwordField.getText();
				int insert = 0;
				if(!name.equals("") && !pass.equals(""))
				{	
					User createdUser = new User(name,pass);
					//addýng arraylist
					insert = Connector.insert_into_db("user", name, pass, 0, 0, 0);
					if(insert >= 1)
					{
						System.out.println("INSERTED");
						JOptionPane.showMessageDialog(null,"You successfully sign in!");
						RunProject.currentUser.setName(createdUser.getName());
						signUpFrame.dispose();
						Menu menu = new Menu();
						System.out.println(RunProject.currentUser);
					}
					else
					{
						System.out.println("NOT INSERTED");
						JOptionPane.showMessageDialog(null,"Name has already taken");
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
		btnNewButton.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(0, 128, 128));
		btnBack.setBackground(UIManager.getColor("Button.darkShadow"));
		btnBack.setBounds(76, 168, 114, 39);
		signUpPanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signUpFrame.dispose();
				StartPage startPg = new StartPage();
			}
		});
		btnBack.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUpFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
