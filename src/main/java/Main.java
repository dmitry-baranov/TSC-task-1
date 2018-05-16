import data.Employee;
import logic.DivisionByDepartment;
import uInteraction.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static ReadWriteFile readWriteFile = new ReadWriteFile();

    private static DivisionByDepartment divisionByDepartment = new DivisionByDepartment();

    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        readWriteFile.readFile(employees);
        divisionByDepartment.toTheDepartment(employees, divisionByDepartment.allDepartments(employees));
        readWriteFile.writeFile(employees);

    }
}