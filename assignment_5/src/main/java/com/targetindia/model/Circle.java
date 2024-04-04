package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Circle {
    protected double radius = 1.0;
    protected String color = "red";
    public Circle(double radius) {
        this.radius=radius;
    }
    public double getArea(){
        return Math.PI * Math.pow(radius,2);
    }
}
