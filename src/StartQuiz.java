import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicLookAndFeel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

public class StartQuiz {

	private JFrame quizFrame;
	int selectedOption = 0;
	ArrayList<String> numberOfQuestion = new ArrayList<>();
	ResultSet rs;
	int id;
	
	String question;
	String[] option = new String[5];
	String correctAns;
	
	int correct;
	int wrong;
	int index;
	Quiz quiz;
	int correctnumber = 0;
	int wrongnumber = 0;
	
	Questions questions;
	final int QUESTIONNUMBER = 5;
	String answer;
	int k = 0;// index of question
	String getQuestion;
	ButtonGroup group = new ButtonGroup();
	
	JRadioButton[] rboption = new JRadioButton[5];
	
	public StartQuiz() {
		try {
			initialize();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		questions = new Questions();
		
		for(int i = 1 ; i < 5 ; i++){
			numberOfQuestion.add(Integer.toString(i));
		}

		quiz = new Quiz();
		for(int i = 0; i < QUESTIONNUMBER; i++)
		{
			index = (int)(Math.random()*questions.questlist.size());
			id = questions.questlist.get(index).getId();
			question = questions.questlist.get(index).getQuestion();
			
			//for every option
			for(int j = 1; j <= 4; j++)
				option[j] = questions.questlist.get(index).getOption(j);
			
			correctAns = questions.questlist.get(index).getCorrectAnswer();
			correct = questions.questlist.get(index).getNumberOfCorrect();
			wrong = questions.questlist.get(index).getNumberOfWrong();
			questions.questlist.remove(index);
			quiz.addQuestion(new Question((id), question, option[1], option[2], option[3], option[4], correctAns, correct, wrong));
			System.out.println(question);
		}
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		quizFrame = new JFrame();
		quizFrame.setResizable(false);
		quizFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\Logo B\u00FCy\u00FCk.png"));
		quizFrame.getContentPane().setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		quizFrame.setTitle("QUIZ");
		quizFrame.setBounds(100, 100, 1000, 600);
		quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//quizFrame.getContentPane().setLayout(null);
		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e2) {
			e2.printStackTrace();
		}
        AudioInputStream ais = null;
		try {
			ais = AudioSystem.getAudioInputStream((new File("images\\baþlýyor.wav")));
		} catch (UnsupportedAudioFileException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        try {
			clip.open(ais);
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        clip.start();
        
        
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
		Border loweredBevel = BorderFactory.createLoweredBevelBorder();
		Border border = BorderFactory.createCompoundBorder(raisedBevel,loweredBevel);
		
		JLabel background=new JLabel(new ImageIcon("images\\frame blank board.png"));
		background.setLayout(null);
		
		JPanel questionPanel = new JPanel();
		questionPanel.setBounds(50, 30, 622, 120);
		background.add(questionPanel);
		questionPanel.setLayout(null);
		questionPanel.setOpaque(false);
		
		JPanel optionPanel = new JPanel();
		optionPanel.setBounds(51, 177, 622, 216);
		background.add(optionPanel);
		optionPanel.setLayout(new GridLayout(3,2));
		optionPanel.setOpaque(false);
		questionPanel.setBorder(border);
		
		JLabel questionLabel = new JLabel();
		questionLabel.setForeground(Color.WHITE);
		questionLabel.setFont(new Font("DKCoolCrayon", Font.BOLD, 25));
		questionLabel.setBorder(border);
		questionLabel.setText("<html>"+quiz.currentQuiz.get(k).getQuestion()+"</html>");
		questionLabel.setBounds(0, 0, 622, 120);
		questionPanel.add(questionLabel);
		
		
		
		for(int i = 1; i <= 4; i++){
			rboption[i] = new JRadioButton();
			rboption[i].setText( "<html>"+ quiz.currentQuiz.get(k).getOption(i)+"</html>");
			rboption[i].addActionListener(new Listener());
			rboption[i].setForeground(Color.WHITE);
			rboption[i].setFont(new Font("DKCoolCrayon", Font.BOLD, 20));
			rboption[i].setBorder(border);
			rboption[i].setOpaque(false);
			group.add(rboption[i]);
			optionPanel.add(rboption[i]);		
		}
		
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBounds(51, 405, 622, 80);
		infoPanel.setLayout(new GridLayout(1,2));
		background.add(infoPanel);
		infoPanel.setVisible(false);
		infoPanel.setOpaque(false);
		
		
		
		JLabel lblCorrectNumber = new JLabel();
		lblCorrectNumber.setBackground(new Color(255, 250, 250));
		lblCorrectNumber.setForeground(Color.WHITE);
		lblCorrectNumber.setFont(new Font("Buxton Sketch", Font.PLAIN, 24));
		lblCorrectNumber.setText("<html>Correct answer is given:<br>"+ quiz.currentQuiz.get(0).getNumberOfCorrect()+" times</html>");
		infoPanel.add(lblCorrectNumber);
		
		JLabel lblWrongNumber = new JLabel();
		lblWrongNumber.setForeground(Color.WHITE);
		lblWrongNumber.setFont(new Font("Buxton Sketch", Font.PLAIN, 25));
		lblWrongNumber.setText("<html>Wrong answer is given:<br>"+quiz.currentQuiz.get(0).getNumberOfWrong()+" times</html>");
		infoPanel.add(lblWrongNumber);
		
		JLabel lblLogo = new JLabel(new ImageIcon("images\\logo küçük.png"));
		lblLogo.setBounds(680, 50, 300, 240);
		background.add(lblLogo);
		
		JButton btnNxtQstn = new JButton("");
		btnNxtQstn.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\next button.png"));
		optionPanel.add(btnNxtQstn);
		btnNxtQstn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(k <= 4)
				{
					Enumeration<AbstractButton> en = group.getElements();
					while(en.hasMoreElements()) 
					{				
						JRadioButton rb = (JRadioButton) en.nextElement();
						if(rb.isSelected())
							answer = rb.getText();
					}
					//System.out.println(answer);
					//System.out.println("<html>" + quiz.currentQuiz.get(k).getCorrectAnswer() + "</html>");
					if(answer.equals("<html>" + quiz.currentQuiz.get(k).getCorrectAnswer() + "</html>"))
					{
						//System.out.println(quiz.currentQuiz.get(k).getId());
						try {
							RunProject.currentUser.solveProblem(quiz.currentQuiz.get(k).getId() - 1);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						Connector.updateQuestion("questions", "noOfCorrect", "questionID", Integer.toString(quiz.currentQuiz.get(k).getId()));
						Connector.updateUser("user" , "noOfCorrect" , "userName" , RunProject.currentUser.getName());
						correctnumber++;
						Clip clip = null;
						try {
							clip = AudioSystem.getClip();
						} catch (LineUnavailableException e2) {
							e2.printStackTrace();
						}
				        AudioInputStream ais = null;
						try {
							ais = AudioSystem.getAudioInputStream((new File("images\\bravo.wav")));
						} catch (UnsupportedAudioFileException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				        try {
							clip.open(ais);
						} catch (LineUnavailableException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				        clip.start();
						JOptionPane.showMessageDialog(null,"Correct!");
						clip.stop();
					}
					else{
						//System.out.println(quiz.currentQuiz.get(k).getId());
						Connector.updateQuestion("questions", "noOfWrong", "questionID",Integer.toString(quiz.currentQuiz.get(k).getId()));
						Connector.updateUser("user" , "noOfWrong" , "userName" , RunProject.currentUser.getName());
						wrongnumber++;
						Clip clip = null;
						try {
							clip = AudioSystem.getClip();
						} catch (LineUnavailableException e2) {
							e2.printStackTrace();
						}
				        AudioInputStream ais = null;
						try {
							ais = AudioSystem.getAudioInputStream((new File("images\\kýrýlma.wav")));
						} catch (UnsupportedAudioFileException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				        try {
							clip.open(ais);
						} catch (LineUnavailableException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				        clip.start();
						JOptionPane.showMessageDialog(null,"Sorry, wrong answer :( \nCorrect answer is : " + quiz.currentQuiz.get(k).getCorrectAnswer());
						clip.stop();
					}
					k++;	
					if(k<=4)
					{	
							
					
						question = quiz.currentQuiz.get(k).getQuestion();
						questionLabel.setText("<html>"+quiz.currentQuiz.get(k).getQuestion()+"<html>");
						for(int i = 1;i<=4;i++)
						{
							option[i] = quiz.currentQuiz.get(k).getOption(i);
							rboption[i].setText("<html>"+quiz.currentQuiz.get(k).getOption(i)+"</html>");
						}
						correct = quiz.currentQuiz.get(k).getNumberOfCorrect();
						lblCorrectNumber.setText("<html>Correct answer is given:<br>"+quiz.currentQuiz.get(k).getNumberOfCorrect()+" times</html>");
						wrong = quiz.currentQuiz.get(k).getNumberOfWrong();
						lblWrongNumber.setText("<html>Wrong answer is given:<br>"+quiz.currentQuiz.get(k).getNumberOfWrong()+" times</html>");
						group.clearSelection();
					}
					
			}
			if(k == 5)
			{
				String str = "You gave " + correctnumber + " correct and " + wrongnumber + " wrong answers!";
				JOptionPane.showMessageDialog(null,str,"Quiz is over!", JOptionPane.INFORMATION_MESSAGE);
				quizFrame.dispose();
				FunPart funPartFrame = new FunPart();
			}
			}
		});
		btnNxtQstn.setFont(new Font("Buxton Sketch", Font.PLAIN, 17));		
		JButton btnQuizOver = new JButton("");
		btnQuizOver.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\finish quiz button.png"));
		btnQuizOver.setFont(new Font("Buxton Sketch", Font.PLAIN, 20));
		
		btnQuizOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = "You gave " + correctnumber + " correct and " + wrongnumber + " wrong answers!" ;
				JOptionPane.showMessageDialog(null,str,"You finished quiz!", JOptionPane.INFORMATION_MESSAGE);
				quizFrame.dispose();
				FunPart funPartFrame = new FunPart();
				
			}
		});
		optionPanel.add(btnQuizOver);
		
		JToggleButton tglbtnShowInfo = new JToggleButton("");
		tglbtnShowInfo.setIcon(new ImageIcon("C:\\Users\\tosh\u0131ba\\Desktop\\Java\\FunnyChemmy\\images\\show statistics.png"));
		tglbtnShowInfo.setFont(new Font("Buxton Sketch", Font.PLAIN, 15));
		tglbtnShowInfo.setBounds(673, 392, 300, 80);
		
		background.add(tglbtnShowInfo);
		
		ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		        if(selected){
		        	infoPanel.setVisible(true);
		        }
		        else
		        {
		        	infoPanel.setVisible(false);
		        }
		      }
		    };
		tglbtnShowInfo.addActionListener(actionListener);
				
		JPanel menuBarPanel = new JPanel();
		menuBarPanel.setBounds(0, 0, 1000, 15);
		quizFrame.getContentPane().add("North",menuBarPanel);
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
				quizFrame.dispose();
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
				      quizFrame.dispose();
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
				JOptionPane.showMessageDialog(null, "Welcome to Quiz!\n"
					+ "Now you have 5 questions quiz.\n"
					+ "By clicking Next button, you can see another question after seeing your result.\n"
					+ "Or you can exit the quiz by clicking Finish Quiz button.\n"
					+ "Also you can see the statistics about each question by toggling Show Statistics button.\n"
					+ "Hope you enjoy!");
			}
		});
		mnHelp.add(mnýtmGetHelp);
		
		quizFrame.getContentPane().add(background);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			for(int i = 1;i <=4;i++)
				if(e.getSource() == rboption[i])
				{
					selectedOption = i;
				}
		}
	}
}


