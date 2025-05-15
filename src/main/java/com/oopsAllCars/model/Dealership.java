package com.oopsAllCars.model;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();

    public Dealership(String _name, String _address, String _phone){
        this.name = _name;
        this.address = _address;
        this.phone = _phone;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        return null;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        return null;
    }

    public List<Vehicle> getVehiclesByYear(String make, String model){
        return null;
    }

    public List<Vehicle> getVehiclesByColor(String make, String model){
        return null;
    }

    public List<Vehicle> getVehiclesByMileage(String make, String model){
        return null;
    }

    public List<Vehicle> getVehiclesByType(String make, String model){
        return null;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);;
    }

    public void removeVehicle(Vehicle vehicle){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }
}
