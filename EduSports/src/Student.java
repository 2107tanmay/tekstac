public abstract class Student {    
    protected int studentId;
    protected String studentName;
    protected String department;
    protected String gender;
    protected String category;
    protected double collegeFee;
    
    // Include a six-argument constructor
    
    //Fill the code here 
    
    public Student(int id, String name, String dept, String gender, String cat, double fee) {
    	this.studentId = id;
    	this.studentName = name;
    	this.department = dept;
    	this.gender = gender; 
    	this.category = cat; 
    	this.collegeFee = fee;
    }
    
    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }
    
    public void setStudentName(String studentName){
        this.studentName = studentName;
    }
    public String getStudentName(){
        return studentName;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    
    public void setCollegeFee(double collegeFee){
        this.collegeFee = collegeFee;
    }
    public double getCollegeFee(){
        return collegeFee;
    }
    
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public int getStudentId(){
        return studentId;
    }
    
    public abstract double calculateTotalFee();
}

