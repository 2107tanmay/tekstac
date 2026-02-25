import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PayrollManager {

	private List<Employee> empList = new ArrayList<>();

	public List<Employee> getEmpList() {
		return empList;
	}

	public void addEmployee(Employee emp) {
    	//Fill the code here
		empList.add(emp);
		}

	public void addMultipleEmployees(List<String> lines) throws InvalidEmployeeException {
		//Fill the code here
		for(String line: lines) {
			Employee emp = PayrollUtil.parseEmployee(line);
			empList.add(emp);
		}
	}

	public List<Employee> getEligibleEmployees(int filterYear, int currentYear, double experiencePercent)
			throws NoEligibleEmployeeException {

    	//Fill the code here
		List<Employee> res = new ArrayList<>();
		Predicate<Employee> predicate = PayrollUtil.joinedBefore(filterYear);
		
		for(Employee emp: empList) {
			if(predicate.test(emp)) {
				
				BiFunction<Employee, Integer, Double> calc = PayrollUtil.computeFinalSalary(experiencePercent);
				double salary = calc.apply(emp, currentYear);
				Consumer<Double> update = PayrollUtil.applyFinalSalary(emp);
				
				update.accept(salary);
				
				res.add(emp);
				
			}
			
		}
		
		return res;
	}

	public Map<String, List<Employee>> groupEmployeesByExperienceRange(int currentYear) {
	    //Fill the code here
		
		return empList.stream()
		.collect(Collectors.groupingBy(emp->{
			int exp = currentYear - emp.getJoiningYear();
			if(exp<=3) {
				return "Junior";
			}
			else if(exp<=7) {
				return "Mid-Level";
			}
			else 
				return "Senior";
		}));
	}
	public List<Employee> sortBySkillCountThenSalary() {
	    //Fill the code here
		return empList.stream()
		.sorted(PayrollUtil.compareBySkillCountThenSalary())
		.collect(Collectors.toList());
	}
	
	public Map<String, Double> getDepartmentWiseSalaryExpense() {
        //Fill the code here
		return empList.stream().collect(
				Collectors.groupingBy(
						Employee::getDepartment,
						Collectors.summingDouble(Employee::getBasicSalary)
						)
				);
	}

	public boolean isDepartmentUnderstaffed(String department, int minimum) {
		//Fill the code here
		return PayrollUtil.isDepartmentUnderstaffed(empList, department, minimum);
	}
}
