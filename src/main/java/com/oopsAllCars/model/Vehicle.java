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
        System.out.printf("vin: %d | year: %d | make: %s | model: %s | vehicleType: %s | color: %s | odometer: %d | price: %.2f\n",
                this.vin, this.year, this.make, this.model, this.vehicleType, this.color, this.odometer, this.price);
    }

    public String getVehicleData(){
        return String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n", this.vin, this.year, this.make, this.model, this.vehicleType, this.color, this.odometer, this.price);
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
