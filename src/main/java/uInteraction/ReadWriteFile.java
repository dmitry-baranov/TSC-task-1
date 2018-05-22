package uInteraction;

import data.Department;
import data.Employee;
import logic.Util;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadWriteFile {

    private static final String FILENAMEREAD = "text.txt";

    private static final String FILENAMEWRITE = "result.txt";

    private List<Department> departments = new ArrayList<>();


    public void start() {
        readFile();
        writeFile();
    }

    private void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAMEREAD))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] s = sCurrentLine.split(";");
                boolean flag = false;
                for (Department d : departments) {
                    if (d.getDepartmentName().equals(s[2])) {
                        d.getEmployeeList().add(new Employee(s[0], s[1], Integer.parseInt(s[3])));
                        flag = true;
                    }
                }
                if (!flag) {
                    Department department = new Department(s[2]);
                    department.getEmployeeList().add(new Employee(s[0], s[1], Integer.parseInt(s[3])));
                    departments.add(department);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(departments);
    }

    private void writeFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILENAMEWRITE, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int of = 0; of < departments.size(); of++) {
            List<Employee> ofList = departments.get(of).getEmployeeList();
            int ofAvgSalary = Util.avgSalary(ofList);
            writer.println("Of department " + departments.get(of).getDepartmentName());
            for (int toThe = 0; toThe < departments.size(); toThe++) {
                if (of != toThe) {
                    List<Employee> toTheList = departments.get(toThe).getEmployeeList();
                    int toTheAvgSalary = Util.avgSalary(toTheList);
                    writer.print("\nTo the department " + departments.get(toThe).getDepartmentName() + ":");
                    List<List<Employee>> result = Util.combination(ofList.size() - 1, new ArrayList<>(), ofList);
                    if (result.size() != 0) {
                        for (List<Employee> listCombination : result) {
                            if (Util.comparisonSalary(ofAvgSalary, toTheAvgSalary, listCombination)) {
                                writer.print("\n");
                                for (Employee e : listCombination) {
                                    writer.print(" Name: " + e.getName() + ", Surname: " + e.getSurname() + ", Salary: " + e.getSalary() + ";");
                                }
                            }
                        }
                    }
                }
            }
            writer.print("\n\n\n");
        }
        writer.close();
    }
}
