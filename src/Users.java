import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Users {
	ResultSet rs1; 
	List<User> userlist;
	int numOfUsers;
	User user;
	public Users() {
		
		userlist = new ArrayList<User>();
	
		Connection con = Connector.getConnection();		
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			rs1 = st.executeQuery("SELECT count(*) FROM user");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		numOfUsers = 0;
		try {
			while (rs1.next()) {
				 numOfUsers = rs1.getInt(1);
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

		String username ="";
		String pass="";
		int correct = 0;
		int wrong = 0;

		ResultSet rs = null;
		try {
			rs = st1.executeQuery("select userName, userPassword, noOfWrong, noOfCorrect from user limit 0, " + numOfUsers + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < numOfUsers; i++)
		{
			try {
				rs.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				username  = rs.getString("userName");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pass = rs.getString("userPassword");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			user = new User(username, pass);
			userlist.add(user);
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
			user.setNumberOfCorrect(correct);
			user.setNumberOfWrong(wrong);
		}
}
	public int getNum()
	{
		return numOfUsers;
	}
	public String getRank()
	{
		//Collections.sort(userlist);
		String str = "<html>";
		for(int i = 0; i<userlist.size(); i++)
		{
			str += (i+1) + " " +  userlist.get(i).toString();
		}
		return str + "</html>";
	}
	
}
