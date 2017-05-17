import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Connector {

	protected static Connection con;
	protected static final String USERNAME = "root";
	protected static final String PASSWORD = "26869031";
	protected static final String CONN_STRING = "jdbc:mysql://localhost/funnychemy";
	
	public static Connection getConnection(){
		Connection con = null;
		try{
			con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
		}
		catch(SQLException e){
			System.err.println(e);
		}
		return con;
	}
	
	public static ResultSet getResult(String tableName){ // get all table data
		ResultSet rs = null;
		try{
			con = getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM "+ tableName);
		}
		catch(SQLException e)
		{
			
		}
		return rs;
	}
	
	public static ResultSet getRowResult(String tableName, String columnName ,int id){  // get only one row from data
		ResultSet rs = null;
		try{
			con = getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM "+ tableName + " WHERE " + columnName + "=" + id);
		}
		catch(SQLException e)
		{
			
		}
		return rs;
	}
	public static ResultSet getConditionalResult(String colName1, String tableName ,String colName2 ,String id){  // get only one cell from data for questions
		ResultSet rs = null;
		try{
			con = getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT "+ colName1 +" FROM "+ tableName + " WHERE " + colName2 + "=" + id);
			
		}
		catch(SQLException e)
		{
			
		}
		return rs;
	}
	public static ResultSet getConditionalStringResult(String colName1, String tableName ,String colName2 ,String id){  // get only one cell from data for users
		ResultSet rs = null;
		try{
			con = getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT "+ colName1 +" FROM "+ tableName + " WHERE " + colName2 + "= '" + id + "'");
			
		}
		catch(SQLException e)
		{
			
		}
		return rs;
	}
	public static ResultSet verifyUser(String colName1,String colName2 ,String tableName , String name, String passw){  // verify user whether specific user is in database or not
		ResultSet rs = null;
		try{
			con = getConnection();
			Statement st = con.createStatement();
			rs = st.executeQuery("SELECT "+ colName1 +"," + colName2  + " FROM " + tableName + " WHERE " + colName1 +  " = '" + name + "' and " + colName2 +" = '" + passw + "'");
			
		}
		catch(SQLException e)
		{
			System.out.println("dshcdch");
			e.printStackTrace();
		}
		return rs;
	}
	
	static String showData (ResultSet rs) throws SQLException 
	{
		StringBuffer sb = new StringBuffer();
		while(rs.next())
		{
			sb.append("Name:" + rs.getString("userName") +",Password:" + rs.getString("userPass") + "\n");
		}
		return sb.toString();
	}
	
	static String showConditionalData (ResultSet rs , String colName) throws SQLException 
	{
		String qstn = "";
		while(rs.next())
		{
			qstn = rs.getString(colName);
		}
		return qstn;
	}

	
	public static int insert_into_db(String tableName,String name,String surname,int wrong, int correct,int bit)
	{
		int inserted = 0;
		try{
			con = getConnection();
			PreparedStatement pStat = con.prepareStatement("INSERT INTO "+ tableName+" VALUES(?,?,?,?,?)");
			pStat.setString(1,name);
			pStat.setString(2,surname);
			pStat.setInt(3,wrong);
			pStat.setInt(4,correct);
			pStat.setInt(5,bit);
			inserted = pStat.executeUpdate();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return inserted;
	}
	public static void updateQuestion(String tableName,String colSet, String colName ,String colID){
		try{
			con =getConnection();
			PreparedStatement pStat = con.prepareStatement("UPDATE " + tableName + " SET " + colSet + " = " + colSet + " + 1 WHERE " + colName + " = " + colID );
			pStat.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}
	public static void updateUser(String tableName,String colSet, String colName ,String userName){
		try{
			con =getConnection();
			PreparedStatement pStat = con.prepareStatement("UPDATE " + tableName + " SET " + colSet + " = " + colSet + " + 1 WHERE " + colName + " = '" + userName +"'");
			pStat.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}
	
	public static void updateBit(String tableName,String colSet, int updatedValue ,String colName ,String userName){
		try{
			con =getConnection();
			PreparedStatement pStat = con.prepareStatement("UPDATE " + tableName + " SET " + colSet + " = " + updatedValue + " WHERE " + colName + " = '" + userName +"'");
			pStat.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}

}
