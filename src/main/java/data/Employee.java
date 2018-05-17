package data;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private String surname;
    private int salary;


}
