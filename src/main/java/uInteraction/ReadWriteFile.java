package uInteraction;

import data.Department;
import data.Employee;
import logic.DivisionByDepartment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {

    private static final String FILENAMEREAD = "text.txt";

    private static final String FILENAMEWRITE = "result.txt";

    private static DivisionByDepartment divisionByDepartment = new DivisionByDepartment();

    public void start() {
        List<Department> departments = new ArrayList<>();
        readFile(departments);
        divisionByDepartment.start(departments);
        writeFile(departments);
    }

    private void readFile(List<Department> departments) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAMEREAD))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] s = sCurrentLine.split(";");
                boolean flag = false;
                for (Department e : departments) {
                    if (e.getDepartmentName().equals(s[0])) {
                        e.getEmployeeList().add(new Employee(s[1], s[2], Integer.parseInt(s[3])));
                        flag = true;
                    }
                }
                if (!flag) {
                    Department department = new Department(s[0]);
                    department.getEmployeeList().add(new Employee(s[1], s[2], Integer.parseInt(s[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeFile(List<Department> departments) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILENAMEWRITE, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int of = 0; of < departments.size(); of++) {
            List<Employee> ofList = departments.get(of).getEmployeeList();
            int ofAvgSalary = divisionByDepartment.avgSalary(ofList);
            for (int toThe = (of +1) ; toThe < departments.size(); toThe++) {
                List<Employee> toTheList = departments.get(toThe).getEmployeeList();
                int toTheAvgSalary = divisionByDepartment.avgSalary(toTheList);
                for (Employee employee : toTheList) {

                }
            }
        }



            writer.println(e.getName() + ";" + e.getSurname() + ";" + e.getDepartment()
                    + ";" + e.getSalary() + "; to the departments: " + (e.getToTheDepartments() == null ?
                    "Can not be transferred" : e.getToTheDepartments()));
        writer.close();
    }
}
