import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class SortMapExample {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "aa");
        map.put(5, "zz");
        map.put(6, "bb");
        map.put(20, "cc");
        map.put(1, "dd");
        map.put(7, "yy");


        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);


        TreeMap<String,Employee> employeeMap=new TreeMap<>();
        Employee employee1=new Employee(1, "Tom", "IT",32);
        Employee employee2=new Employee(3, "Tim", "sales",14);
        Employee employee3=new Employee(2, "Steve", "Account",37);
        Employee employee4=new Employee(4, "Smith", "Finance",12);
        employeeMap.put(employee1.getName(),employee1);
        employeeMap.put(employee2.getName(),employee2);
        employeeMap.put(employee3.getName(),employee3);
        employeeMap.put(employee4.getName(),employee4);

        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.println("-------------------------------------------");
        employeeMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getAge))).forEach(System.out::println);

    }

}
