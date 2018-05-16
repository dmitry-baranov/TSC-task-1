package uInteraction;

import data.Employee;

import java.io.*;
import java.util.List;

public class ReadWriteFile {

    private static final String FILENAMEREAD = "text.txt";

    private static final String FILENAMEWRITE = "result.txt";

    public void readFile(List<Employee> employees) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAMEREAD))) {
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
    }

    public void writeFile(List<Employee> employees) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILENAMEWRITE, "UTF-8");
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
