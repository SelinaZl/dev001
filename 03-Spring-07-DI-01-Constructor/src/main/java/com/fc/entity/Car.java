package com.fc.entity;

public class Car {
    private Float spend;
    private String color;

    public Car(Float spend, String color) {
        this.spend = spend;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "spend=" + spend +
                ", color='" + color + '\'' +
                '}';
    }
}
