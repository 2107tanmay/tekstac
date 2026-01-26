import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Exam Details:");
        System.out.println("Student Name:");
        String name = sc.nextLine();
        System.out.println("Question Type (MCQ/Coding)");
        String type = sc.nextLine();
        System.out.println("Total Questions:");
        int total = sc.nextInt(); sc.nextLine();
        System.out.println("Correct Answers:");
        int correct = sc.nextInt(); sc.nextLine();
        System.out.println("Wrong Answers:");
        int wrong = sc.nextInt(); sc.nextLine();
        
        OnlineTest obj = new OnlineTest(name,total,correct,wrong,type);
        
        System.out.println("Exam Summary:");
        System.out.println(type+" Test: "+name+", Total Score: "+obj.calculateScore()+", Result: "+Exam.evaluateResult(obj.calculateScore()));
        
        
}
}