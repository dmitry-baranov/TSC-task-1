package logic;

import data.Employee;

import java.util.List;

public class Util {

    public static int avgSalary(List<Employee> employees) {
        int sumSalary = 0;
        for (Employee employee : employees) {
            sumSalary += employee.getSalary();
        }
        return (sumSalary / (employees.size()));
    }
}
