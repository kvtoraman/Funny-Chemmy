
public class Question {
	int id;
	String question;
	String[] option = new String[5];
	String correctAnswer;
	int numberOfWrong;
	int numberOfCorrect;
	
	public Question(int id,String question,String o1,String o2,String o3,String o4,String correctAnswer,int noCorrect , int noWrong){
		this.id = id;
		this.question = question;
		this.option[1] = o1;
		this.option[2] = o2;
		this.option[3] = o3;
		this.option[4] = o4;
		this.correctAnswer = correctAnswer;
		numberOfCorrect = noCorrect;
		numberOfWrong = noWrong;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption(int id) {
		return option[id];
	}

	public void setOption(int id, String option) {
		this.option[id] = option;
	}

	

	public int getNumberOfWrong() {
		return numberOfWrong;
	}

	public void setNumberOfWrong(int numberOfWrong) {
		this.numberOfWrong = numberOfWrong;
	}

	public int getNumberOfCorrect() {
		return numberOfCorrect;
	}

	public void setNumberOfCorrect(int numberOfCorrect) {
		this.numberOfCorrect = numberOfCorrect;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	
	
	

}
