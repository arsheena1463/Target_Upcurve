package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString (callSuper = true)
@NoArgsConstructor
public class Student extends Person{
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee){
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }


}
