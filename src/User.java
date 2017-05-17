import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class User {
	ResultSet rs;
	String name;
	String password;
	int numberOfCorrect;
	int numberOfWrong;
	int bitwise; // keeps track of solved questions
	final int QUESTIONNUMBER = 5;
	int point = 0;
	public User(String theName, String thePassword){
		name = theName;
		password = thePassword;
		numberOfCorrect = 0;
		numberOfWrong = 0;
		bitwise = 0;
	}
	public User(){
		numberOfCorrect = 0;
		numberOfWrong = 0;
		bitwise = 0;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getNumberOfCorrect() {
		return numberOfCorrect;
	}


	public void setNumberOfCorrect(int numberOfCorrect) {
		this.numberOfCorrect = numberOfCorrect;
		point = numberOfCorrect * 3 - numberOfWrong ;
	}


	public int getNumberOfWrong() {
		return numberOfWrong;
	}


	public void setNumberOfWrong(int numberOfWrong) {
		this.numberOfWrong = numberOfWrong;
		point = numberOfCorrect * 3 - numberOfWrong ;
	}


	public int getBitwise() {
		return bitwise;
	}


	public void setBitwise(int bitwise) {
		this.bitwise = bitwise;
	}
	public int getPoint(){
		return point;
	}
	// ýd ler 0 dan baslýyor
	public void solveProblem( int no) throws SQLException{
		
		rs = Connector.getConditionalStringResult("bit", "user", "userName", name);
		String tempBit = Connector.showConditionalData(rs, "bit");
		int bit = Integer.parseInt(tempBit);
		
		bit |= (1 << no);
		Connector.updateBit("user", "bit", bit, "userName", name);
	}
	public int getUnsolvedProblems() throws SQLException{
		
		ArrayList<Integer> al = new ArrayList<>();
		rs = Connector.getConditionalStringResult("bit", "user", "userName", name);
		String tempBit =Connector.showConditionalData(rs, "bit");
		int bit = Integer.parseInt(tempBit);
		System.out.println(bit);
		/*
		 * for(int i = 0; i < QUESTIONNUMBER; i++)
		 
			if( (bit & (1 << i)) == 0)
				al.add(i);	*/
				
		return bit;
	}
	public String toString(){
		return  name + " " + point + "<br>";
	}
	public int compareTo(User anotherInstance) {
        if( this.getPoint() < anotherInstance.getPoint())
        	return 1;
        if( this.getPoint() > anotherInstance.getPoint())
        	return -1;
        return 0;
    	}
	
}
