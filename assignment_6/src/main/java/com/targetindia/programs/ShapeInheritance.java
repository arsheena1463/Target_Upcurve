package com.targetindia.programs;

import com.targetindia.model.Circle;
import com.targetindia.model.Rectangle;
import com.targetindia.model.Shape;
import com.targetindia.model.Square;

public class ShapeInheritance {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(),
                new Circle(2.5),
                new Circle(3, "beige", false),
                new Rectangle(),
                new Rectangle(2.5, 2.5),
                new Rectangle(3, 4, "lilac", true),
                new Square(),
                new Square(5.0),
                new Square(7.0, "lavender", true)
        };
        for (int i=0;i < shapes.length; i++){
            System.out.println(shapes[i].toString());
        }

    }
}
