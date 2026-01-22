import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the sentence");
	    String s = sc.nextLine();

	    String words[] = s.split(" ");
	    
	    if(! s.matches("^[a-zA-z ]+$")) {
	    	System.out.println("Invalid Sentence");
	    	return;
	    }
	    
	    System.out.println("Word Count: "+words.length);
	    
	    if(words.length%2==0) {
	    	String res = swap(words);
	    	System.out.println(res);
	    	return;
	    }
	    else{
	    	String res = reverse(words);
	    	System.out.println(res);
	    	return;
	    }
	}
	
	public static String reverse(String[] s) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<s.length; i++) {
			char ch[] = s[i].toCharArray();
			int end = ch.length-1;
			for(int j=0; j<ch.length/2; j++) {
				char temp = ch[j];
				ch[j]=ch[end];
				ch[end] = temp;
				end--;
			}
			sb.append(ch);
			if(i != s.length-1) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	public static String swap(String[] s) {
		StringBuilder sb = new StringBuilder();
		int end = s.length-1;
		for(int i=0; i<s.length/2; i++) {
			String temp = s[i];
			s[i] = s[end];
			s[end] = temp;
			end--;
		}
		
		for(int i=0; i<s.length; i++) {
			sb.append(s[i]);
			if(i != s.length) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
