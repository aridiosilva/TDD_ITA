package solidprinciples;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class OrdenarLista {


	public static void main(String[] args) 
	{
		ArrayList<Employee> employees = getUnsortedEmployeeList();

		//Compare by first name and then last name
		Comparator<Employee> compareByName = Comparator
				.comparing(Employee::getFirstName)
				.thenComparing(Employee::getLastName);

		List<Employee> sortedEmployees = employees.stream()
				.sorted(compareByName)
				.collect(Collectors.toList());

		for (int i = 0; i < sortedEmployees.size(); i++) {
			System.out.println("id = "         + sortedEmployees.get(i).getId() +
							   "FirstName = "  + sortedEmployees.get(i).getFirstName() +
							   "LastName = "   + sortedEmployees.get(i).getLastName());
		}

	}

	private static ArrayList<Employee> getUnsortedEmployeeList() 
	{
		ArrayList<Employee> list = new ArrayList<>();
		
		list.add( new Employee(2l, "Lokesh", "Gupta") );
		list.add( new Employee(1l, "Alex", "Gussin") );
		list.add( new Employee(4l, "Brian", "Sux") );
		list.add( new Employee(5l, "Neon", "Piper") );
		list.add( new Employee(3l, "David", "Beckham") );
		list.add( new Employee(7l, "Alex", "Beckham") );
		list.add( new Employee(6l, "Brian", "Suxena") );
		return list;
	}


}
