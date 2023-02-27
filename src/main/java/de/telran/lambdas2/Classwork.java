package de.telran.lambdas2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Classwork {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Emp1", "Surname1", new BigDecimal(100L), "driver", 35),
                new Employee("Emp2", "Surname2", new BigDecimal(200L), "scribe", 28),
                new Employee("Emp3", "Surname3", new BigDecimal(50L), "intern", 19),
                new Employee("Emp4", "Surname4", new BigDecimal(500L), "accountant", 55),
                new Employee("Emp5", "Surname5", new BigDecimal(700L), "director", 45),
                new Employee("Emp6", "Surname6", new BigDecimal(300L), "master", 50),
                new Employee("Emp7", "Surname3", new BigDecimal(300L), "office-manager", 27),
                new Employee("Emp2", "Surname5", new BigDecimal(700L), "director", 45)
        );

        //Count all employees who earns not less than 400, and who's age is more than 40
        long employeesCount = employees.stream()
//                .filter(new Predicate<Employee>() {
//                    @Override
//                    public boolean test(Employee employee) {
//                        return employee.getSalary().compareTo(BigDecimal.valueOf(400)) >= 0 && employee.getAge() > 40;
//                    }
//                })
                .filter(employee -> employee.getSalary().compareTo(BigDecimal.valueOf(400)) >= 0 && employee.getAge() > 40)
                .count();

        System.out.println(employeesCount);

        System.out.println(countEmployees(employees));


        List<EmployeeDto> dtos = List.of(
                new EmployeeDto("Ivan Ivanov", "engineer"),
                new EmployeeDto("Petr Petrov", "receptionist"),
                new EmployeeDto("Sidor Sidorov", "manager")
        );

        EmployeeMapper mapper = new EmployeeMapper();

        dtos.stream()
//                .map(new Function<EmployeeDto, Employee>() {
//                    @Override
//                    public Employee apply(EmployeeDto employeeDto) {
//                        String[] name = employeeDto.getFullName().split(" ");
//                                   //    if (...)             {   } else {}
////                        String anotherName;
////                        if (name.length >= 1) {
////                            anotherName = name[0];
////                        } else {
////                            anotherName = "";
////                        }
//                        String firstName = name.length >= 1 ? name[0] : "";
//                        String lastName = name.length >= 2 ? name[1] : "";
//                        return new Employee(
//                                firstName,
//                                lastName,
//                                BigDecimal.ZERO,
//                                employeeDto.getPosition(),
//                                0
//                        );
//                    }
//                })
//                .forEach(Classwork::saveToDb);
//                .map(dto -> mapper.mapToEntity(dto))
                .peek(Classwork::otherSave)
                .map(mapper::mapToEntity)
                .peek(Classwork::saveToDb)
                .toList();

        Optional<Employee> opt = employees.stream()
                .findFirst();

//        if (opt.isPresent()) {
//            System.out.println(opt.get());
//        }
//       Optional<EmployeeDto> dto = opt.map(EmployeeDto::new);
        Employee result = opt.orElseThrow(() -> new IllegalArgumentException("No employee matching filter"));
//        Employee res = opt.orElse(new Employee());
        Employee res = opt.orElseGet(new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        });
//        return result;

        System.out.println("\n====================================\n");
        employees.stream()
//                .takeWhile(new Predicate<Employee>() {
//                    @Override
//                    public boolean test(Employee employee) {
//                        return employee.getAge() < 50;
//                    }
//                })
                .takeWhile(e -> e.getAge() < 50)
                .forEach(System.out::println);

        System.out.println("\n====================================\n");
        employees.stream()
//                .takeWhile(new Predicate<Employee>() {
//                    @Override
//                    public boolean test(Employee employee) {
//                        return employee.getAge() < 50;
//                    }
//                })
                .dropWhile(e -> e.getAge() < 50)
                .forEach(System.out::println);

        System.out.println("\n====================================\n");
        employees.stream()
                .skip(3)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("\n====================================\n");

        employees.stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n====================================\n");

        Optional<Employee> max = employees.stream()
                .max((emp1, emp2) -> emp1.getSalary().compareTo(emp2.getSalary()));
        System.out.println(max.get());

        System.out.println("\n====================================\n");

        Optional<Employee> min = employees.stream()
                .min((emp1, emp2) -> emp1.getSalary().compareTo(emp2.getSalary()));
        System.out.println(min.get());

        System.out.println("\n====================================\n");

        List<Department> departments = List.of(
                new Department("One", List.of(
                        new Employee("Emp1", "Surname1", new BigDecimal(100L), "driver", 35),
                        new Employee("Emp2", "Surname2", new BigDecimal(200L), "scribe", 28),
                        new Employee("Emp3", "Surname3", new BigDecimal(50L), "intern", 19),
                        new Employee("Emp4", "Surname4", new BigDecimal(500L), "accountant", 55),
                        new Employee("Emp5", "Surname5", new BigDecimal(700L), "director", 45),
                        new Employee("Emp6", "Surname6", new BigDecimal(300L), "master", 50),
                        new Employee("Emp7", "Surname3", new BigDecimal(300L), "office-manager", 27)
                )),
                new Department("Two", List.of(
                        new Employee("Emp11", "Surname11", new BigDecimal(100L), "driver", 35),
                        new Employee("Emp22", "Surname21", new BigDecimal(200L), "scribe", 28),
                        new Employee("Emp33", "Surname33", new BigDecimal(50L), "intern", 19),
                        new Employee("Emp44", "Surname44", new BigDecimal(500L), "accountant", 55),
                        new Employee("Emp55", "Surname55", new BigDecimal(700L), "director", 45),
                        new Employee("Emp66", "Surname66", new BigDecimal(300L), "master", 50),
                        new Employee("Emp77", "Surname33", new BigDecimal(300L), "office-manager", 27)
                )),
                new Department("Three", List.of(
                        new Employee("Emp111", "Surname111", new BigDecimal(100L), "driver", 35),
                        new Employee("Emp222", "Surname222", new BigDecimal(200L), "scribe", 28),
                        new Employee("Emp333", "Surname333", new BigDecimal(50L), "intern", 19),
                        new Employee("Emp444", "Surname444", new BigDecimal(500L), "accountant", 55),
                        new Employee("Emp555", "Surname555", new BigDecimal(700L), "director", 45),
                        new Employee("Emp666", "Surname666", new BigDecimal(300L), "master", 50),
                        new Employee("Emp777", "Surname333", new BigDecimal(300L), "office-manager", 27)
                ))
        );
        System.out.println("\n====================================\n");

        departments.stream()
//                .flatMap(new Function<Department, Stream<?>>() {
//                    @Override
//                    public Stream<?> apply(Department department) {
//                        return department.getEmployees().stream();
//                    }
//                })
                .flatMap(dep -> dep.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("\n====================================\n");
        Stream<Employee> employeeStream = Stream.of(
                new Employee("Emp1", "Surname1", new BigDecimal(100L), "driver", 35),
                new Employee("Emp2", "Surname2", new BigDecimal(200L), "driver", 35)
                );

        Stream.concat(employees.stream(), employeeStream)
                .findFirst();
        new Random().ints(100).mapToObj(new IntFunction<EmployeeDto>() {
            @Override
            public EmployeeDto apply(int value) {
                return new EmployeeDto(String.format("Name%d Surname%d", value, value), String.format("Position%d", value));
            }
        }).forEach(System.out::println);

//        String.format()
//        "str".formatted()
//        System.out.printf();
        int num = 43;
        String surname = "surname";
        String position = "position";
        String complicatedString = "Employee #" + num + ", surname " + surname  + ", position " + position;
        String template = "Employee #%d, surname %s, position %s";

        System.out.println(complicatedString);
        String fromTemplate = template.formatted(num, surname, position);
        System.out.println(fromTemplate);
        System.out.printf(template, num, surname, position);
    }

    static void saveToDb(Employee employee) {
        System.out.printf("Employee %s saved\n", employee);
    }

    static void otherSave(EmployeeDto employee) {
        System.out.printf("Employee %s saved\n", employee);
    }

    static long countEmployees(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.getSalary().compareTo(BigDecimal.valueOf(400)) >= 0 && employee.getAge() > 40)
                .count();
    }
}
