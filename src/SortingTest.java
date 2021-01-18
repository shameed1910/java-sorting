import java.util.*;
import java.util.stream.Collectors;

public class SortingTest {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("EE", "A", "F", "BBB", "ZZZZ");
        //ASC order
        Collections.sort(list);//A, BBB, EE, F, ZZZZ
        //DESC order
        Collections.sort(list,Comparator.reverseOrder());//ZZZZ, F, EE, BBB, A

        list.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------------------------------------");

        //length sort using sorted
        list.stream().sorted(
                (String name1, String name2) -> name1.length() - name2.length()).
                forEach(System.out::println);// F, A, EE, BBB, ZZZZ
        System.out.println("----------------------------------------");

        //length sort using Comparator
        list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("----------------------------------------");// F, A, EE, BBB, ZZZZ

        //length sort using multiple Comparator
        list.stream().sorted(Comparator.comparingInt(String::length).
                thenComparing(Comparator.naturalOrder())).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------------------------------------");// A, F, EE, BBB, ZZZZ

        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Tom", "IT",32),
                new Employee(3, "Tim", "sales",14),
                new Employee(2, "Steve", "Account",37),
                new Employee(4, "Smith", "Finance",12));


        Collections.sort(employeeList, Comparator.comparing(Employee::getName));
        Collections.sort(employeeList, Comparator.comparing(Employee::getName).reversed());

        System.out.println("----------------------------------------");

        //sorting by using lambda expression
        employeeList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        employeeList.forEach(System.out::println);

        //Sort with ASC order
        employeeList.stream().sorted(Comparator.comparing(Employee::getDepartment)).collect(Collectors.toList()).
                forEach(System.out::println);

        //Sort with DESC order
        employeeList.stream().sorted(Comparator.comparing(Employee::getDepartment).reversed()).collect(Collectors.toList()).
                forEach(System.out::println);



        System.out.println("----------------------------------------");
        //Sort with multiple comparators
        Comparator<Employee> compareByNameandAge= Comparator.comparing(Employee::getName).thenComparing(Employee::getAge);
        employeeList.stream().sorted(compareByNameandAge).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("----------------------------------------");

        Integer[] numbers = {22, 89, 1, 32, 19, 5};

        Arrays.sort(numbers);//[1,5,19,22,32,89]
        Collections.sort(Arrays.asList(numbers));//[1,5,19,22,32,89]

        Arrays.stream(numbers).sorted().toArray();//[1,5,19,22,32,89]
        Arrays.stream(numbers).sorted(Collections.reverseOrder()).toArray();//[89,32,22,19,5,1]
        Arrays.stream(numbers).sorted(Comparator.reverseOrder()).toArray();//[89,32,22,19,5,1]
        Arrays.stream(numbers).sorted(Comparator.naturalOrder()).toArray(Integer[]::new);//[1, 5, 19, 22, 32, 89]
        //Sort with Parallel sort
        Arrays.parallelSort(numbers);
        Arrays.stream(numbers).forEach(System.out::println);

    }
}



