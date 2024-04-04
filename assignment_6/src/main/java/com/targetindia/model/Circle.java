package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Circle extends Shape{
    private double radius = 1.0;
    public Circle(double radius, String color, boolean filled){
        this.radius = radius;
        super.color = color;
        super.filled = filled;
    }
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    public String toString(){
        return "A Circle with radius=" + radius + ", which is a subclass of " + super.toString();
    }
}
