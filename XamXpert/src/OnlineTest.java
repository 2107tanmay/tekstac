public class OnlineTest implements Exam {
	private String studentName;
	private int totalQuestions;
	private int correctAnswers;
	private int wrongAnswers;
	private String questionType;

	public OnlineTest(String studentName, int totalQuestions, int correctAnswers, int wrongAnswers,
			String questionType) {
		this.studentName = studentName;
		this.totalQuestions = totalQuestions;
		this.correctAnswers = correctAnswers;
		this.wrongAnswers = wrongAnswers;
		this.questionType = questionType;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public int getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(int correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	public int getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	// Override the calculateScore method
	@Override 
	public double calculateScore() {
		double total = 0;
		double percentage = 0;
		if(questionType.equals("MCQ")) {
			total = (correctAnswers*2)-(wrongAnswers*(2*0.10));
			percentage = (total/(totalQuestions*2))*100;
			return percentage;
		}
		else if(questionType.equals("Coding")) {
			total = (correctAnswers*5)-(wrongAnswers*(5*0.10));
			percentage = (total/(totalQuestions*5))*100;
			return percentage;
		}
		else {
			System.out.println("invalid question type");
		}
		return -1;
	}
	
}
