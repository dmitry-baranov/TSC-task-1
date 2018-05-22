package logic;

import data.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilTest extends Assert {

    private static final List<Employee> employeeList = new ArrayList<>();

    @Before
    public void setEmployeeList() {
        employeeList.add(new Employee("abv", "abc", 1000));
        employeeList.add(new Employee("abv1", "abc", 5000));
        employeeList.add(new Employee("abv2", "abc", 7000));
        employeeList.add(new Employee("abv3", "abc", 15000));
    }

    @After
    public void clearEmployeeList() {
        employeeList.clear();
    }

    @Test
    public void avgSalaryTest() {
        assertEquals(Util.avgSalary(employeeList), 7000);
    }

    @Test
    public void combination() {
        assertEquals(Util.combination(employeeList.size() - 1, new ArrayList<>(), employeeList).size(), 15);
    }

    @Test
    public void comparisonSalary() {

        assertTrue(Util.comparisonSalary(10000, 5000, employeeList));
        assertFalse(Util.comparisonSalary(7000, 5000, employeeList));
        assertFalse(Util.comparisonSalary(10000, 7000, employeeList));

    }

}