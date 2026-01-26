public interface Exam {
    // Fill the code here 
	public double calculateScore();
	
	public static String evaluateResult(double percentage) {
		if(percentage >= 85) return "Merit";
		if(percentage>=60) return "Pass";
		return "Fail";
	}
}
