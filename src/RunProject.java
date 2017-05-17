import java.awt.EventQueue;
import java.util.ArrayList;


public class RunProject {

	protected static String currentUserName;
	protected static User currentUser = new User();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartPage window = new StartPage();
					window.startFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	 }
	}


