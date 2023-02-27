package de.telran.lambdas2;

import java.math.BigDecimal;

public class EmployeeMapper {

    public Employee mapToEntity(EmployeeDto employeeDto) {
        String[] name = employeeDto.getFullName().split(" ");
        String firstName = name.length >= 1 ? name[0] : "";
        String lastName = name.length >= 2 ? name[1] : "";
        return new Employee(
                firstName,
                lastName,
                BigDecimal.ZERO,
                employeeDto.getPosition(),
                0
        );
    }
}
