import java.util.ArrayList;


public class Quiz {
	ArrayList<Question> currentQuiz;
	public Quiz(){
		currentQuiz = new ArrayList<Question>();
	}
	public void addQuestion(Question q){
		currentQuiz.add(q);
	}
	public Question getQuestion(int index){
		return currentQuiz.get(index);
	}

}
