import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GifList {
	ResultSet rs1; 
	ArrayList<Gif> giflist;
	int numOfGifs;
	public GifList() {
		
		giflist = new ArrayList<Gif>();
	
		Connection con = Connector.getConnection();		
		Statement st = null;
		try {
			st = con.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			rs1 = st.executeQuery("SELECT count(*) FROM gif");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		numOfGifs = 0;
		try {
			while (rs1.next()) {
				 numOfGifs = rs1.getInt(1);
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

		String gifName ="";
		String url="";

		ResultSet rs = null;
		try {
			rs = st1.executeQuery("select gifName, url from gif limit 0, " + numOfGifs + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < numOfGifs; i++)
		{
			try {
				rs.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				gifName  = rs.getString("gifName");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				url = rs.getString("url");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			giflist.add(new Gif(gifName, url));
		}
}
	public int getNum()
	{
		return numOfGifs;
	}
	
}