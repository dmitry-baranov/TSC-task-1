package logic;

import data.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilTest extends Assert {

    private static final List<Employee> employeeList = new ArrayList<>();

    @Before
    public void setEmployeeList() {
        employeeList.add(new Employee("abv", "abc", BigInteger.valueOf(1000)));
        employeeList.add(new Employee("abv1", "abc", BigInteger.valueOf(5000)));
        employeeList.add(new Employee("abv2", "abc", BigInteger.valueOf(7000)));
        employeeList.add(new Employee("abv3", "abc", BigInteger.valueOf(15000)));
    }

    @After
    public void clearEmployeeList() {
        employeeList.clear();
    }

    @Test
    public void avgSalaryTest() {
        assertTrue(Util.avgSalary(employeeList).equals(BigInteger.valueOf(7000)));
    }

    @Test
    public void combination() {
        assertEquals(Util.combination(employeeList.size() - 1, new ArrayList<>(), employeeList).size(), 15);
    }

    @Test
    public void comparisonSalary() {

        assertTrue(Util.comparisonSalary(BigInteger.valueOf(10000), BigInteger.valueOf(5000), employeeList));
        assertFalse(Util.comparisonSalary(BigInteger.valueOf(7000), BigInteger.valueOf(5000), employeeList));
        assertFalse(Util.comparisonSalary(BigInteger.valueOf(10000), BigInteger.valueOf(7000), employeeList));

    }

}