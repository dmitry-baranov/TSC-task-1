package logic;

import data.Employee;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static int avgSalary(List<Employee> employees) {
        int sumSalary = 0;
        for (Employee employee : employees) {
            sumSalary += employee.getSalary();
        }
        return (sumSalary / (employees.size()));
    }

    public static List<List<Employee>> combination(int n, List<List<Employee>> result, List<Employee> employees) {
        if (n == 0) {
            result.add(new ArrayList<>());
            result.get(result.size() - 1).add(employees.get(n));
            return result;
        } else {
            List<List<Employee>> previous = combination(n - 1, result, employees);
            int l = previous.size();
            for (int i = 0; i < l; i++) {
                List<Employee> data = new ArrayList<>(previous.get(i));
                data.add(employees.get(n));
                previous.add(data);
            }
            previous.add(new ArrayList<>());
            previous.get(previous.size() - 1).add(employees.get(n));
            return previous;
        }

    }

    public static boolean comparisonSalary(int ofAvgSalary, int toTheAvgSalary, List<Employee> list) {
        return (((avgSalary(list)) < ofAvgSalary) & (avgSalary(list) > toTheAvgSalary));
    }
}
