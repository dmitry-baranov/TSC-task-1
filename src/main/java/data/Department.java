package data;

import java.util.ArrayList;
import java.util.List;


public class Department implements Comparable<Department> {

    String departmentName;
    List<Employee> employeeList = new ArrayList<>();

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    //    public boolean equalsNotList(Object o) {
//        if (o == this) {
//            return true;
//        } else if (!(o instanceof Department)) {
//            return false;
//        } else {
//            Department other = (Department)o;
//            if (!other.canEqual(this)) {
//                return false;
//            } else {
//                Object this$departmentName = this.getDepartmentName();
//                Object other$departmentName = other.getDepartmentName();
//                if (this$departmentName == null) {
//                    if (other$departmentName != null) {
//                        return false;
//                    }
//                } else if (!this$departmentName.equals(other$departmentName)) {
//                    return false;
//                }
//
//                return true;
//            }
//        }
//    }
//    protected boolean canEqual(Object other) {
//        return other instanceof Department;
//    }
//
    @Override
    public int compareTo(Department o) {
        return departmentName.compareTo(o.departmentName);
    }
}
