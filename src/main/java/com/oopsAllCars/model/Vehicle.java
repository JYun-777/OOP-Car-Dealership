package com.oopsAllCars.model;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int _vin, int _year, String _make, String _model,
                        String _vehicleType, String _color, int _odometer, double _price){
        this.vin = _vin;
        this.year = _year;
        this.make = _make;
        this.model = _model;
        this.vehicleType = _vehicleType;
        this.color = _color;
        this.odometer = _odometer;
        this.price = _price;
    }

    public void display(){
        System.out.printf("%d | %d | %s | %s | %s | %s | %d | %d");
    }
}
