package logic;

import data.Employee;

import java.util.*;

public class DivisionByDepartment {

//    private int avgSalary(List<Employee> employees, String department) {
//        int sumSalary = 0;
//        for (Employee e : employees) {
//            if (e.getDepartment().equals(department)) {
//                sumSalary += e.getSalary();
//            }
//        }
//        return (sumSalary / (employees.size()));
//    }

    public Map<String, Integer> searchDepartments(List<Employee> employees) {

//        Set<String> set = new HashSet<>();
//        for (Employee e : employees) {
//            set.add(e.getDepartment());
//        }
//        return set;

        Map<String, Integer> departments = new HashMap<>();
        for (Employee e : employees) {
            departments.put(e.getDepartment(), departments.get(e.getDepartment()) == null ? e.getSalary() : departments.get(e.getDepartment()) + e.getSalary());
        }
        for (Map.Entry<String, Integer> department : departments.entrySet()) {
            int i = 0;
            for (Employee e : employees) {
                if (department.getKey().equals(e.getDepartment())) {
                    i++;
                }
            }
            departments.put(department.getKey(), department.getValue() / i);
        }
        return departments;
    }

    public void toTheDepartment(List<Employee> listEmployees, Map<String, Integer> mapDepartments) {
        for (Employee employee : listEmployees) {
            if (employee.getSalary() < mapDepartments.get(employee.getDepartment())) {
                for (Map.Entry<String, Integer> department : mapDepartments.entrySet()) {
                    if (employee.getSalary() > department.getValue()) {
                        employee.setToTheDepartments(employee.getToTheDepartments() == null ? department.getKey() : employee.getToTheDepartments()  + ";" + department.getKey());
                    }
                }
            }

        }
    }
}
