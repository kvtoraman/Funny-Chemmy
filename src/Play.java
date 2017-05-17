import java.sql.ResultSet;
import java.sql.SQLException;


public class Play {

	public static void main(String[] args) throws NumberFormatException, SQLException {
		ResultSet rs;
		String q;
		String o1;
		String o2;
		String o3;
		String o4;
		int corr;
		int wrong;
		
		rs = Connector.getConditionalResult("question","questions","questionID","1");
		q = Connector.showConditionalData(rs , "question");
		rs = Connector.getConditionalResult("option_1","questions","questionID","1");
		o1 = Connector.showConditionalData(rs , "option_1");
		rs = Connector.getConditionalResult("option_2","questions","questionID","1");
		o2 = Connector.showConditionalData(rs , "option_2");
		rs = Connector.getConditionalResult("option_3","questions","questionID","1");
		o3 = Connector.showConditionalData(rs , "option_3");
		rs = Connector.getConditionalResult("option_4","questions","questionID","1");
		o4 = Connector.showConditionalData(rs , "option_4");
		rs = Connector.getConditionalResult("noOfWrong","questions","questionID","1");
		wrong = Integer.parseInt(Connector.showConditionalData(rs , "noOfWrong"));
		rs = Connector.getConditionalResult("noOfCorrect","questions","questionID",1+1+"");
		corr = Integer.parseInt(Connector.showConditionalData(rs , "noOfCorrect"));
		
		rs = Connector.getConditionalStringResult("reactionInfo", "reactions", "reactionType", "combustion");
		Reaction r= new Reaction("combustion",Connector.showConditionalData(rs, "reactionInfo"));
		System.out.println(r.getReactionData());
		
		//Question q1 = new Question(1,q,o1,o2,o3,o4,corr,wrong);
		//System.out.println(q1.getQuestion());
		//System.out.println(q1.getId());
		//System.out.println(q1.getNumberOfWrong());


	}

}
