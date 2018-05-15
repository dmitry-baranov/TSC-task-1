package data;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private String surname;
    private String department;
    private int salary;
    private String toTheDepartments = "";

}
