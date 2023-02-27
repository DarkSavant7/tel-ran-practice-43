package de.telran.lambdas2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaExample {

    public static void main(String[] args) {
//        simpleExample();
//        streamExample();

        String text = """
                ol[jnerfgo[jknefvoj[nevffolnj[
                njkervlknle[wfjknvo[jwertnb
                ljk[kwernboj[nerqgonoqerngijwetbp
                """;

        String[] arr = text.split(" ");

        List<List<Employee>> complicatedStruct = List.of(
                List.of(
                        new Employee("Emp1", "Surname1", new BigDecimal(100L), "driver", 35),
                        new Employee("Emp2", "Surname2", new BigDecimal(200L), "scribe", 28),
                        new Employee("Emp3", "Surname3", new BigDecimal(50L), "intern", 19),
                        new Employee("Emp4", "Surname4", new BigDecimal(500L), "accountant", 55),
                        new Employee("Emp5", "Surname5", new BigDecimal(700L), "director", 45),
                        new Employee("Emp6", "Surname6", new BigDecimal(300L), "master", 50),
                        new Employee("Emp7", "Surname3", new BigDecimal(300L), "office-manager", 27)
                ),
                List.of(
                        new Employee("Emp11", "Surname11", new BigDecimal(100L), "driver", 35),
                        new Employee("Emp22", "Surname21", new BigDecimal(200L), "scribe", 28),
                        new Employee("Emp33", "Surname33", new BigDecimal(50L), "intern", 19),
                        new Employee("Emp44", "Surname44", new BigDecimal(500L), "accountant", 55),
                        new Employee("Emp55", "Surname55", new BigDecimal(700L), "director", 45),
                        new Employee("Emp66", "Surname66", new BigDecimal(300L), "master", 50),
                        new Employee("Emp77", "Surname33", new BigDecimal(300L), "office-manager", 27)
                ),
                List.of(
                        new Employee("Emp111", "Surname111", new BigDecimal(100L), "driver", 35),
                        new Employee("Emp222", "Surname222", new BigDecimal(200L), "scribe", 28),
                        new Employee("Emp333", "Surname333", new BigDecimal(50L), "intern", 19),
                        new Employee("Emp444", "Surname444", new BigDecimal(500L), "accountant", 55),
                        new Employee("Emp555", "Surname555", new BigDecimal(700L), "director", 45),
                        new Employee("Emp666", "Surname666", new BigDecimal(300L), "master", 50),
                        new Employee("Emp777", "Surname333", new BigDecimal(300L), "office-manager", 27)
                )
        );

        var flatList = complicatedStruct.stream()
//                .flatMap(new Function<List<Employee>, Stream<Employee>>() {
//                    @Override
//                    public Stream<Employee> apply(List<Employee> employees) {
//                        return employees.stream();
//                    }
//                })
                .flatMap(Collection::stream)
                .filter(e -> e.getAge() >= 30 && e.getAge() <= 50)
//                .sorted((e1, e2) -> e2.getSalary().compareTo(e1.getSalary()))
//                .allMatch(e -> e.getSalary().compareTo(BigDecimal.valueOf(100)) >= 0);
//                .allMatch(e -> e.getSalary().compareTo(BigDecimal.valueOf(300)) >= 0);
//                .anyMatch(e -> e.getSalary().compareTo(BigDecimal.valueOf(300)) >= 0);
//                .anyMatch(e -> e.getSalary().compareTo(BigDecimal.valueOf(1000)) >= 0);
//                .noneMatch(e -> e.getSalary().compareTo(BigDecimal.valueOf(1000)) >= 0);
//                .noneMatch(e -> e.getSalary().compareTo(BigDecimal.valueOf(600)) >= 0);
        .findFirst()
                .orElseThrow(IllegalArgumentException::new);
//                .orElseThrow(() -> new RuntimeException("AAAA"));
//                .orElseThrow(new Supplier<RuntimeException>() {
//                    @Override
//                    public RuntimeException get() {
//                        return new RuntimeException("AAAAAAAAA");
//                    }
//                });
//                .toList();
//                .collect(Collectors.toMap(
//                        Employee::getSalary,
//                        e -> new ArrayList(List.of(e)),
//                        (e1, e2) -> {
//                            e1.addAll(e2);
//                            return e1;
//                        }
//                ));

        System.out.println(flatList);
    }

    private static void streamExample() {
        List<Employee> employees = List.of(
                new Employee("Emp1", "Surname1", new BigDecimal(100L), "driver", 35),
                new Employee("Emp2", "Surname2", new BigDecimal(200L), "scribe", 28),
                new Employee("Emp3", "Surname3", new BigDecimal(50L), "intern", 19),
                new Employee("Emp4", "Surname4", new BigDecimal(500L), "accountant", 55),
                new Employee("Emp5", "Surname5", new BigDecimal(700L), "director", 45),
                new Employee("Emp6", "Surname6", new BigDecimal(300L), "master", 50),
                new Employee("Emp7", "Surname3", new BigDecimal(300L), "office-manager", 27)
        );

//        List<Employee> sorted = employees.stream()
//                .filter(e -> e.getSalary().compareTo(BigDecimal.valueOf(300L)) > 0)
//                .sorted((e1, e2) -> e1.getPosition().compareTo(e2.getPosition()))
//                .toList();
//
//        System.out.println(sorted);
//
//        System.out.println();
//
//        System.out.println(employees);

//        Integer[] arr = {1, 2, 3, 4, 5, 6};
//        Arrays.stream(arr);

//        employees.stream();

//        Stream.of(1,2,3,4,5);

        var emp = employees.stream()
//                .takeWhile(e -> e.getAge() < 50)
//                .dropWhile(e -> e.getAge() < 50)
//                .filter(e -> e.getSalary().compareTo(BigDecimal.valueOf(200)) > 0)
//                .map(new Function<Employee, EmployeeDto>() {
//                    @Override
//                    public EmployeeDto apply(Employee employee) {
//                        return new EmployeeDto(employee);
//                    }
//                })
//                .map(e -> new EmployeeDto(e.getName() + " " + e.getLastName(), e.getPosition()))
//                .map(EmployeeDto::new)
//                .map(new Function<Employee, String>() {
//                    @Override
//                    public String apply(Employee employee) {
//                        return String.format("Employee %s %s position: %s, salary: %s",
//                                employee.getName(),
//                                employee.getLastName(),
//                                employee.getPosition(),
//                                employee.getSalary()
//                        );
//                    }
//                })
//                .map(employee -> String.format("Employee %s %s position: %s, salary: %s",
//                        employee.getName(),
//                        employee.getLastName(),
//                        employee.getPosition(),
//                        employee.getSalary()
//                ))
//                .dropWhile(new Predicate<Employee>() {
//                    @Override
//                    public boolean test(Employee employee) {
//                        //.....
//                        return employee.getAge() < 40 && employee.getSalary().compareTo(BigDecimal.valueOf(150)) > 0;
//                    }
//                })
//                .forEach(e -> System.out.println(e.getName()))
//                .count();
//                .toList();
//        .collect(Collectors.toMap(Employee::getLastName, Employee::getPosition));
//        .collect(Collectors.toMap(Employee::getLastName, Function.identity(), new BinaryOperator<Employee>() {
//            @Override
//            public Employee apply(Employee employee, Employee employee2) {
////                return employee2.getSalary().compareTo(employee.getSalary()) > 0 ? employee2 : employee;
//                return new Employee(
//                        employee.getName() + " " + employee2.getName(),
//                        employee.getLastName(),
//                        employee.getSalary()
//                                .add(employee2.getSalary())
//                                .divide(BigDecimal.valueOf(2),
//                                        new MathContext(2, RoundingMode.HALF_UP)),
//                        employee.getPosition() + " " + employee2.getPosition(),
//                        (employee.getAge() + employee2.getAge()) / 2
//                );
//            }
//        }));
                .collect(Collectors.toMap(
                        Employee::getLastName,
                        Function.identity(),
                        (e1, e2) -> e1.getAge() > e2.getAge() ? e1 : e2)
                );


        System.out.println(emp);
    }

    private static void simpleExample() {
        List<String> list = List.of(
                "One", "Two", "Three", "Four", "Five", "Six"
        );

        Function<String, Integer> fun1 = string -> string.length();
        Function<String, Integer> fun2 = String::length;


        List<Integer> integers = new ArrayList<>();

        for (String s : list) {
            integers.add(s.length());
        }

        List<Integer> integers1 = list.stream()
                .map(fun2)
                .toList();

        System.out.println(integers);

        System.out.println(integers1);
    }
}
