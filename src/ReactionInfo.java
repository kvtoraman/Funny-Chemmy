import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;


public class ReactionInfo {

	protected JFrame infoFrame;

	public ReactionInfo(String name,String data) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		infoFrame = new JFrame();
		infoFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\Logo B\u00FCy\u00FCk.png"));
		infoFrame.setResizable(false);
		infoFrame.setBounds(100, 100, 557, 454);
		infoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		infoFrame.setTitle(name + " Reaction");
		
		JLabel background=new JLabel(new ImageIcon("images\\frame blank board.png"));
		background.setLayout(null);
		
		
		JPanel infoPanel = new JPanel();
		infoPanel.setOpaque(false);
		infoPanel.setBounds(43, 30, 468, 320);
		infoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblInfo = new JLabel();
		lblInfo.setOpaque(false);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("DKCoolCrayon", Font.PLAIN, 14));
		lblInfo.setText("<html>"+data+"</html>" );
		infoPanel.add(lblInfo);
		
		background.add(infoPanel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoFrame.dispose();
				ChemicalReaction reactionFrame = new ChemicalReaction();
			}
		});
		btnBack.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		btnBack.setBounds(105, 361, 145, 43);
		background.add(btnBack);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoFrame.dispose();
				Menu menu = new Menu();
			}
		});
		btnMenu.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		btnMenu.setBounds(330, 361, 145, 43);
		background.add(btnMenu);
	
		infoFrame.getContentPane().add(background);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					infoFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	}

