package org.springProject.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Person {
    public int personId;
    public String personName;
    public int age;
    public String occupation;
    public String eirCode;
}
