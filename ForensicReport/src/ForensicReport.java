import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ForensicReport {

	private Map<String,Date> reportMap=new HashMap<String,Date>();

	public Map<String, Date> getReportMap() {
		return reportMap;
	}

	public void setReportMap(Map<String, Date> reportMap) {
		this.reportMap = reportMap;
	}

    public void addReportDetails(String reportingOfficer, Date reportFiledDate) {
		reportMap.put(reportingOfficer, reportFiledDate);
	}

	public List<String> getOfficersWhoFiledReportsOnDate(Date reportFiledDate){
		List<String> l = new ArrayList();
		for(Map.Entry<String, Date> m: reportMap.entrySet()) {
			if(m.getValue().equals(reportFiledDate)) {
				l.add(m.getKey());
			}
		}
		return l;
	}
}
