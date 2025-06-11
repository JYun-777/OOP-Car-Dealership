package com.oopsAllCars.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();

    private ArrayList<Vehicle> filteredInventory = new ArrayList<Vehicle>();

    public Dealership(String _name, String _address, String _phone){
        this.name = _name;
        this.address = _address;
        this.phone = _phone;
    }

    public String getDealershipData(){
        return String.format("%s|%s|%s\n",this.name,this.address,this.phone);
    }

    public Optional<Vehicle> getVehicleByVin(double _vin){
        for (Vehicle _vehicle: inventory){
            if (_vehicle.getVin() == _vin){
                return Optional.of(_vehicle);
            }
        }
        return Optional.empty();
    }

    public List<Vehicle> getVehiclesByPrice(double _min, double _max){
        for (Vehicle _vehicle: inventory){
            if (_vehicle.getPrice() > _min && _vehicle.getPrice() < _max){
                filteredInventory.add(_vehicle);
            }
        }

        return filteredInventory;
    }

    public List<Vehicle> getVehiclesByMakeModel(String _make, String model){
        for (Vehicle _vehicle: inventory){
            if (_vehicle.getMake().contains(_make) && _vehicle.getModel().contains(model)){
                filteredInventory.add(_vehicle);
            }
        }

        return filteredInventory;
    }

    public List<Vehicle> getVehiclesByYear(int _year){
        for (Vehicle _vehicle: inventory){
            if (_vehicle.getYear() == _year){
                filteredInventory.add(_vehicle);
            }
        }

        return filteredInventory;
    }

    public List<Vehicle> getVehiclesByColor(String _color){
        for (Vehicle _vehicle: inventory){
            if (_vehicle.getColor().contains(_color)){
                filteredInventory.add(_vehicle);
            }
        }

        return filteredInventory;
    }

    public List<Vehicle> getVehiclesByMileage(double _minMile, double _maxMile){
        for (Vehicle _vehicle: inventory){
            if (_vehicle.getPrice() > _minMile && _vehicle.getPrice() < _maxMile){
                filteredInventory.add(_vehicle);
            }
        }

        return filteredInventory;
    }

    public List<Vehicle> getVehiclesByType(String _type){
        for (Vehicle _vehicle: inventory){
            if (_vehicle.getVehicleType().contains(_type)){
                filteredInventory.add(_vehicle);
            }
        }

        return filteredInventory;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
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
