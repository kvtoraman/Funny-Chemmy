import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HighScores extends JPanel{
	Users allUsers;
	public HighScores(){
		
		allUsers = new Users();
		//setLayout(null);
		JLabel label = new JLabel(allUsers.getRank());
		add(label);
		
	}
	

}