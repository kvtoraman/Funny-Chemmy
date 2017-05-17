import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// keeps unsolved questions
public class Questions {
	ResultSet rs1; 
	ArrayList<Question> questlist;
	int numOfQuests;
	Question question;
	
	public Questions() throws SQLException {
		
		
		questlist = new ArrayList<Question>();
	
		Connection con = Connector.getConnection();		
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			rs1 = st.executeQuery("SELECT count(*) FROM questions");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		numOfQuests = 0;
		
		
		try {
			while (rs1.next()) {
				 numOfQuests = rs1.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		Connection con1 = Connector.getConnection();			
		Statement st1 = null;
		try {
			st1 = con1.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int id = 0;
		String questionS ="";
		String option1="";
		String option2="";
		String option3="";
		String option4="";
		String answer = "";
		int correct = 0;
		int wrong = 0;

		ResultSet rs = null;
		try {
			rs = st1.executeQuery("select questionID, question, option_1, option_2, option_3, option_4, answerOfQuestion, noOfCorrect, noOfWrong from questions limit 0, " + numOfQuests + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < numOfQuests; i++)
		{
			try {
				rs.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//this if statement checks whether ith question solved or not
			if((RunProject.currentUser.getUnsolvedProblems() & (1 << i)) > 0){
				continue;
			}
			try {
				id  = rs.getInt("questionID");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				questionS  = rs.getString("question");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				option1 = rs.getString("option_1");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				option2 = rs.getString("option_2");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				option3 = rs.getString("option_3");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				option4 = rs.getString("option_4");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				answer = rs.getString("answerOfQuestion");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				correct  = rs.getInt("noOfCorrect");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				wrong = rs.getInt("noOfWrong");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			question = new Question(id, questionS, option1, option2, option3, option4, answer, correct, wrong);
			questlist.add(question);
			
		}
}
	public int getNum()
	{
		return numOfQuests;
	}
	
}