package com.targetindia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shape {
    protected String color = "red";
    protected boolean filled = true;
    public String toString(){
        return "A Shape with color of " + color + " and " + (filled?"filled":"not filled");
    }

}
