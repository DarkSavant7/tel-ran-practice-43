package de.telran.lambdas2;

import java.math.BigDecimal;

public class EmployeeDto {
    private String fullName;
    private String position;


    public EmployeeDto(String fullName, String position) {
        this.fullName = fullName;
        this.position = position;
    }

    public EmployeeDto(Employee employee) {
        this.fullName = employee.getName() + " " + employee.getLastName();
        this.position = employee.getPosition();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return "EmployeeDto{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
