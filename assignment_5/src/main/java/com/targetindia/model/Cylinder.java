package com.targetindia.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cylinder extends Circle{
    private double height = 1.0;
    public Cylinder(double radius){
        super.radius = radius;
    }
    public Cylinder(double radius, double height){
        super.radius = radius;
        this.height = height;
    }
    public Cylinder(double radius, double height, String color){
        super.radius = radius;
        this.height = height;
        super.color = color;
    }

    public double getVolume(){
        return getArea() * height;
    }
}
