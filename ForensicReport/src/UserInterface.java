import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInterface{
    public static void main(String args[]) throws ParseException{
		Scanner sc=new Scanner(System.in);
		ForensicReport fr = new ForensicReport();
		List<String> res = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		
		System.out.println("Enter number of reports to be added");
		int count = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Forensic reports (Reporting Officer: ReportFiled Date)");
		for(int i=0; i<count; i++) {
			String input = sc.nextLine();
			String data[] = input.split(":");
			Date date = sdf.parse(data[1]);
			fr.addReportDetails(data[0], date);
		}
		
		System.out.println("Enter the filed date to identify the reporting officers");
		String date = sc.nextLine();
		Date key = sdf.parse(date);
		
		res = fr.getOfficersWhoFiledReportsOnDate(key);
		
		if(res.isEmpty()) {
			System.out.println("No reporting officer filed the report");
			return;
		}
		
		System.out.println("Reports filed on the "+date+" are by");
		
		for(String list: res) System.out.println(list);
	}

}


