import data.Employee;
import logic.Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String FILENAME = "text.txt";

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] s = sCurrentLine.split(";");
                employees.add(Employee.builder()
                        .name(s[0])
                        .surname(s[1])
                        .department(s[2])
                        .salary(Integer.parseInt(s[3]))
                        .build());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Util.toTheDepartment(employees, Util.allDepartments(employees));
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("result.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (Employee e : employees) {
            writer.println(e.getName() + ";" + e.getSurname() + ";" + e.getDepartment()
                    + ";" + e.getSalary() + "; to the departments: " + (e.getToTheDepartments() == null ?
                    "Can not be transferred" : e.getToTheDepartments()));
        }
        writer.close();

    }
}