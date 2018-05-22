package uInteraction;

import data.Department;
import data.Employee;
import errors.MyException;
import errors.Response;
import logic.Util;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWriteFile {

    private static final String FILENAMEREAD = "text.txt";

    private static final String FILENAMEWRITE = "result.txt";

    private Map<String, Department> departments = new HashMap<>();

    public void start() {
        try {
            readFile();
            writeFile();
        } catch (MyException e) {
            System.out.println(e.toString());
        }

    }

    private void readFile() throws NumberFormatException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAMEREAD))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] s = sCurrentLine.split(";");
                if (!departments.containsKey(s[2])) {
                    departments.put(s[2], new Department());
                }
                departments.get(s[2]).getEmployeeList().add(new Employee(s[0], s[1], new BigInteger(s[3])));
            }
        } catch (IOException e) {
            throw new MyException(Response.FILE_NOT_FOUND);
        } catch (NumberFormatException e) {
            throw new MyException(Response.INVALID_INPUT_DATA);
        }
    }

    private void writeFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(FILENAMEWRITE, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println("Результрующий файл не найден");
        }
        for (Map.Entry<String, Department> departmentEntryFrom : departments.entrySet()) {
            List<Employee> fromList = departmentEntryFrom.getValue().getEmployeeList();
            BigInteger ofAvgSalary = Util.avgSalary(fromList);
            writer.println("From department " + departmentEntryFrom.getKey());
            for (Map.Entry<String, Department> departmentEntryTo : departments.entrySet()) {
                if (!departmentEntryFrom.getKey().equals(departmentEntryTo.getKey())) {
                    List<Employee> toTheList = departmentEntryTo.getValue().getEmployeeList();
                    BigInteger toTheAvgSalary = Util.avgSalary(toTheList);
                    writer.print("\nTo the department " + departmentEntryTo.getKey() + ":");
                    List<List<Employee>> result = Util.combination(fromList.size() - 1, new ArrayList<>(), fromList);
                    if (result.size() != 0) {
                        for (List<Employee> listCombination : result) {
                            if (Util.comparisonSalary(ofAvgSalary, toTheAvgSalary, listCombination)) {
                                writer.print("\n");
                                for (Employee e : listCombination) {
                                    writer.print(" Name: " + e.getName() + ", Surname: " + e.getSurname() + ", "
                                            + "Salary: " + e.getSalary().toString() + ";");
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
