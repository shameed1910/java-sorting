import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Tom", "IT",32),
                new Employee(3, "Tim", "sales",14),
                new Employee(2, "Steve", "Account",37),
                new Employee(4, "Smith", "Finance",12));
        List<String> list =null;

        extracted(employeeList);

    }

    private static void extracted(List<Employee> employeeList) {
        for (Employee employee: employeeList) {
            List<String> list =Arrays.asList("EE", "A", "F", "BBB", "ZZZZ");;
            for (String s:list) {
                System.out.println(s);
                return;
            }

            System.out.println(employee);
            return;
        }
    }
}
