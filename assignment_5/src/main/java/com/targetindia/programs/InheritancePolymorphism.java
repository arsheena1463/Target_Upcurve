package com.targetindia.programs;


import com.targetindia.model.Circle;
import com.targetindia.model.Cylinder;

public class InheritancePolymorphism {
    public static void main(String[] args) {
        Circle[] circles = {
                new Cylinder(12.34),
                new Cylinder(12.34, 10.0),
                new Cylinder(12.34, 10.0, "blue")
        };
        for (int i=0;i < circles.length;i++){
            Cylinder cylinder = (Cylinder) circles[i];
            System.out.printf("Cylinder %d: \n", i+1);
            System.out.printf("Area: %f\n",circles[i].getArea());
            System.out.printf("Volume: %f\n",cylinder.getVolume());
            System.out.println("-------");//Just a separator


        }
    }
}
