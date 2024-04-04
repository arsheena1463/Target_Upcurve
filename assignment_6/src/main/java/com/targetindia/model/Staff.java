package com.targetindia.model;

import com.targetindia.model.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString (callSuper = true)
public class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay){
        super(name, address);
        this.school = school;
        this.pay = pay;
    }
}
