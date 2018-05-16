package data;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private String surname;
    private int salary;


}
