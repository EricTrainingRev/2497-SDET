package com.revature.annotations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// with three annotations we get all the code from the Person class but our code stays cleaner
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonAnnotated {
    private String name;
    private int age;
}
