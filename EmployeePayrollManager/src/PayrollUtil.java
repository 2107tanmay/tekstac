import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.Arrays;
import java.util.Comparator;

public class PayrollUtil {

  
    public static Employee parseEmployee(String input) throws InvalidEmployeeException {
        
    	String[] parts = input.split(":");

        // validate format
        if (parts.length != 7) {
            throw new InvalidEmployeeException("Invalid employee format");
        }

        String employeeId = parts[0];
        String name = parts[1];
        String department = parts[2];
        double basicSalary = Double.parseDouble(parts[3]);
        int joiningYear = Integer.parseInt(parts[4]);
        double rating = Double.parseDouble(parts[5]);

        // skills parsing using stream
        List<String> skills = Arrays.stream(parts[6].split(","))
                                    .map(String::trim)
                                    .collect(Collectors.toList());

        return new Employee(
                employeeId,
                name,
                department,
                basicSalary,
                joiningYear,
                rating,
                skills
        );

    }

    public static Predicate<Employee> joinedBefore(int year) {
        // Fill the code here
        return emp -> emp.getJoiningYear()<year;
    }

    public static Function<Employee, Double> computeBonus() {
        // Fill the code here
        return emp -> emp.getBasicSalary()*(emp.getRating()/100);
    }
   
    public static BiFunction<Employee, Integer, Double> computeFinalSalary(double experiencePercent) {
        // Fill the code here
        return (emp, currentYear) -> {
        	double salary = emp.getBasicSalary();
        	double bonus = computeBonus().apply(emp);
        	int exp = currentYear - emp.getJoiningYear();
        	double expincrement =0;
        	
        	if(exp>=5) {
        		expincrement = salary *(experiencePercent/100);
        	}
        	return salary+bonus+expincrement;
        };
    }
    public static Consumer<Double> applyFinalSalary(Employee e) {
        // Fill the code here
        return finalsal -> e.setBasicSalary(finalsal);
    }

    public static Comparator<Employee> compareBySkillCountThenSalary() {
        // Fill the code here
        return Comparator
        		.comparing((Employee e) -> e.getSkills().size())
        		.reversed()
        		.thenComparing(Employee::getBasicSalary, Comparator.reverseOrder());  
    }
    public static double departmentWiseSalaryExpense(List<Employee> empList, String department) {
        // Fill the code here
    	return empList.stream()
    	.filter(emp-> emp.getDepartment().equals(department))
    	.mapToDouble(Employee::getBasicSalary)
    	.sum();
    }
    public static boolean isDepartmentUnderstaffed(List<Employee> empList, String department, int minimum) {
        // Fill the code here
        return empList.stream()
        		.filter(emp -> emp.getDepartment().equals(department))
        		.count()<minimum;
    }


}
