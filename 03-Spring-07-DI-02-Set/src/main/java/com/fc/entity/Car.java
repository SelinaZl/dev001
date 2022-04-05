package com.fc.entity;

public class Car {
    private Float spend;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "spend=" + spend +
                ", color='" + color + '\'' +
                '}';
    }


    public Float getSpend() {
        return spend;
    }

    public void setSpend(Float spend) {
        this.spend = spend;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
