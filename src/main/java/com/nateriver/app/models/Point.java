package com.nateriver.app.models;



public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void print(){
        System.out.println("x is " + this.x + ", y is " + this.y);
    }
}
