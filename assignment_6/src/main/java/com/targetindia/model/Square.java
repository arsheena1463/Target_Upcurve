package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Square extends Rectangle{
    private double side = 1.0;
    public Square(double side, String color, boolean filled){
        this.side = side;
        super.color = color;
        super.filled = filled;
    }
    public String toString(){
        return "A Square with side=" + side + ", which is a subclass of " + super.toString();
    }
}
