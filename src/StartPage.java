import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;


public class StartPage {

	JFrame startFrame;
	/**
	 * Create the application.
	 */
	public StartPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws  
	 */
	private void initialize() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		startFrame = new JFrame();
		startFrame.setResizable(false);
		startFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		startFrame.setTitle("FUNNY CHEMY");
		startFrame.setBounds(200, 100, 1000, 600);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//startFrame.getContentPane().setLayout(null);
		
		JLabel background=new JLabel(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\frame.png"));
		background.setLayout(null);
		
		JPanel startPanel = new JPanel();
		startPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), new Color(0, 255, 0), new Color(0, 255, 0), new Color(0, 255, 0)));
		startPanel.setBackground(new Color(0, 128, 128));
		startPanel.setForeground(new Color(255, 255, 255));
		startPanel.setBounds(555, 89, 385, 441);
		startPanel.setLayout(null);
		background.add(startPanel);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\login button.png"));
		startPanel.add(btnLogin);
		btnLogin.setToolTipText("Click to Login");
		btnLogin.setBounds(71, 55, 262, 96);
		btnLogin.setFont(new Font("Buxton Sketch", Font.PLAIN, 15));
		
		JButton btnSignUp = new JButton("");
		startPanel.add(btnSignUp);
		btnSignUp.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\sign up button.png"));
		btnSignUp.setToolTipText("Click to Sign Up");
		btnSignUp.setBounds(71, 178, 262, 96);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startFrame.dispose();
				SignUp signUp = new SignUp();
			}
		});
		btnSignUp.setFont(new Font("Buxton Sketch", Font.PLAIN, 15));
		
		JButton btnOptons = new JButton("");
		btnOptons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//startFrame.dispose();
				JFrame f = new JFrame();
				f.getContentPane().add(new HighScores());
				f.pack();
				f.setVisible(true);
			}
		});
		startPanel.add(btnOptons);
		btnOptons.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\champions button.png"));
		btnOptons.setToolTipText("Click for Options");
		btnOptons.setBounds(71, 307, 262, 96);
		btnOptons.setFont(new Font("Buxton Sketch", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startFrame.dispose();
				Login login = new Login();
			}
		});
		startFrame.getContentPane().add(background);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
