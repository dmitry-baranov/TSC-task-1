package logic;

import data.Department;
import data.Employee;
import lombok.Data;

import java.util.*;

@Data
public class DivisionByDepartment {

    //    private Map<String, Integer> departments = new HashMap<>();

    Map<Integer, List<Employee>> resultMap = new HashMap<>();

//    public Map<String, Integer> searchDepartments(List<Employee> employees) {
//
////        Set<String> set = new HashSet<>();
////        for (Employee e : employees) {
////            set.add(e.getDepartment());
////        }
////        return set;
//
//        for (Employee e : employees) {
//            departments.put(e.getDepartment(), departments.get(e.getDepartment()) == null ? e.getSalary() : departments.get(e.getDepartment()) + e.getSalary());
//        }
//        for (Map.Entry<String, Integer> department : departments.entrySet()) {
//            int i = 0;
//            for (Employee e : employees) {
//                if (department.getKey().equals(e.getDepartment())) {
//                    i++;
//                }
//            }
//            departments.put(department.getKey(), department.getValue() / i);
//        }
//        return departments;
//    }

//    public void toTheDepartment(List<Employee> listEmployees, Map<String, Integer> mapDepartments) {
//        for (Employee employee : listEmployees) {
//            if (employee.getSalary() < mapDepartments.get(employee.getDepartment())) {
//                for (Map.Entry<String, Integer> department : mapDepartments.entrySet()) {
//                    if (employee.getSalary() > department.getValue()) {
//                        employee.setToTheDepartments(employee.getToTheDepartments() == null ? department.getKey() : employee.getToTheDepartments()  + ";" + department.getKey());
//                    }
//                }
//            }
//
//        }
//    }


    public void toTheDepartment(List<Employee> employees, int ofAvgSalary, int toTheAvgSalary, int n, int sumSalary, int j) {
        int thisSumSalary = 0;
        if (employees.size() == 1 ) {
            return;
        } else if (thisSumSalary / (n+1) > toTheAvgSalary) {
            return;
        } else {
            for (int i = n; i < employees.size(); i++) {
                thisSumSalary = sumSalary + employees.get(i).getSalary();
                if (((thisSumSalary /(n+1)) < ofAvgSalary) & ( (thisSumSalary /(n+1)) > toTheAvgSalary)) {
                    if (!resultMap.containsKey(j)) {
                        resultMap.put(j, new ArrayList<>());
                    }
                    resultMap.get(j).add(employees.get(i));
                }
                if (employees.size() != n+2) {
                    int p = n + 1;
                    int z = j + 1;
                    toTheDepartment(employees, ofAvgSalary, toTheAvgSalary, p, thisSumSalary, z);
                }

            }
//            toTheDepartment(employees, ofAvgSalary, toTheAvgSalary, n, thisSumSalary);
        }
    }

    public void toTheDep(List<Employee> employees, int ofAvgSalary, int toTheAvgSalary, int n, int sumSalary, int j) {
        int thisSumSalary = 0;
        if (employees.size() == 1 ) {
            return;
        } else {
            for (int i = n; i < employees.size(); i++) {
                thisSumSalary = sumSalary + employees.get(i).getSalary();
                if (((thisSumSalary /(n+1)) < ofAvgSalary) & ( (thisSumSalary /(n+1)) > toTheAvgSalary)) {
                    if (!resultMap.containsKey(j)) {
                        resultMap.put(j, new ArrayList<>());
                    }
                    resultMap.get(j).add(employees.get(i));
                }
                if (employees.size() != n+2) {
                    int p = n + 1;
                    int z = j + 1;
                    toTheDepartment(employees, ofAvgSalary, toTheAvgSalary, p, thisSumSalary, z);
                }

            }
//            toTheDepartment(employees, ofAvgSalary, toTheAvgSalary, n, thisSumSalary);
        }
    }

//    public List<Department> recursion(Department department, Department departmentToThe, List<Department> departments) {
//
//    }
//
//    private void writeList(String department, List<Employee> employees) {
//        List<List<Employee>> listsEmployee = combinationEmployee.get(department);
//        for (Employee e : newList) {
//            newList.
//        }
//
//    }

}
