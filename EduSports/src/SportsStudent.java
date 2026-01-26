public class SportsStudent extends Student {

	private String sportName;
	private String level; 
	//Include a eight-argument constructor
	public SportsStudent(int id, String name, String dept, String gender, String cat, double fee, String sportName, String level) {
		super(id, name, dept, gender, cat, fee);
		this.sportName = sportName;
		this.level = level;
	}
	//Fill the code here
	public void setSportName(String sportName){
		this.sportName = sportName;
	}
	public String getSportName(){
		return sportName;
	}

	public void setLevel(String level){
		this.level = level;
	}
	public String getLevel(){
		return level;
	}

	public double calculateTotalFee() {
		double sportsFee = 0;
		double bonus = 0;

		if(level.equals("State")) sportsFee = 5000;
		else if(level.equals("National")) sportsFee = 10000;
		else if(level.equals("International")) sportsFee = 20000;
		else return -1;
		
		if(sportName.equals("Cricket")||sportName.equals("Football")) bonus=3000;
		else if(sportName.equals("Athletics")) bonus = 1500;
		else return -1;
		
		return collegeFee + (sportsFee + bonus);
	}
}
