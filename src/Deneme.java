import java.util.*;

public class Deneme {
	static ArrayList<String> users = new ArrayList<>();
	static final int MAX_USER = 50;
	static long[] column = new long[MAX_USER];
	
	static int hash(String str){
		for(int i = 0; i < MAX_USER; i++)
			if(users.get(i).equals(str))
				return i;
		System.out.println("CANNOT FIND USER");
		return -1;
	}
	
	static void solveProblem(String userName, int no){
		column[hash(userName)] |= (1 << no);
		
	}
	public static ArrayList<Integer> getUnsolvedProblems(String userName){
		
		ArrayList<Integer> al = new ArrayList<>();
		for(int i = 0;i < 10; i++)
			if( (column [ hash(userName) ] & (1 << i)) == 0)
				al.add(i);	
		return al;
	}
	public static void main(String[] args){
		users.add("kamil");
		users.add("erkan");
		users.add("merve");
		users.add("muammer");
		//ArrayList<Integer> al = new ArrayList<>();
		solveProblem("kamil" , 1);
		System.out.println(getUnsolvedProblems("kamil"));
		
		solveProblem("kamil" , 0);
		solveProblem("kamil" , 3);

		System.out.println(getUnsolvedProblems("kamil"));
		
		solveProblem("erkan",0);
		solveProblem("erkan",1);
		solveProblem("erkan",2);
		solveProblem("erkan",3);
		
		System.out.println(getUnsolvedProblems("erkan"));
	
	
	
	}
	

}
