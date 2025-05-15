package com.oopsAllCars.ui;

import com.oopsAllCars.data.DealershipFileManager;
import com.oopsAllCars.model.Dealership;
import com.oopsAllCars.model.Vehicle;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    private Dealership dealership;

    private void init(){
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership();
    }

    private void displayVehicles(List<Vehicle> _vehicles){
        for (Vehicle vehicle: _vehicles){
            vehicle.display();
        }
    }

    public void display(){
        init();

        String menuOption;
        Scanner read = new Scanner(System.in);
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~ Car Dealership Inventory ~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Please enter an option: \n 1) ");
            System.out.print(" >>  ");
            menuOption = read.nextLine();
            processGetAllVehiclesRequest();
        }

    }

    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processGetByPriceRequest(){

    }
    public void processGetByMakeModelRequest(){

    }
    public void processGetByYearRequest(){

    }
    public void processGetByColorRequest(){

    }
    public void processGetByMileageRequest(){

    }
    public void processGetByVehicleTypeRequest(){

    }

    public void processAddVehicleRequest(){

    }

    public void processRemoveVehicleRequest(){

    }

    public Dealership getDealership(){
        return this.dealership;
    }
}
