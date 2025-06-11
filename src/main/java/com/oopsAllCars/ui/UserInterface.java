package com.oopsAllCars.ui;

import com.oopsAllCars.data.DealershipFileManager;
import com.oopsAllCars.model.Dealership;
import com.oopsAllCars.model.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    private Dealership dealership;
    private Scanner read = new Scanner(System.in);
    private DealershipFileManager dfm = new DealershipFileManager();


    private void init(){
        this.dealership = dfm.getDealership();
    }

    private void displayVehicles(List<Vehicle> _vehicles){
        for (Vehicle vehicle: _vehicles){
            vehicle.display();
        }
    }

    public void display(){
        init();

        int menuOption;
        while(true){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~ Car Dealership Inventory ~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("""
                    Please enter an option:
                    1) Display all vehicles
                    2) Add new vehicle
                    3) Remove vehicle
                    """);
            System.out.print(" >>  ");
            menuOption = read.nextInt();
            read.nextLine();

            switch (menuOption){
                case 1 -> processGetAllVehiclesRequest();
                case 2 -> processAddVehicleRequest();
                case 3 -> processRemoveVehicleRequest();
            }

        }

    }

    public void processGetAllVehiclesRequest(){
        System.out.println("Listing all vehicles:");
        displayVehicles(dealership.getAllVehicles());
    }

    public void processGetByPriceRequest(){
        System.out.println("Enter a price range:");
        System.out.println("Minimum price: ");
        double minPrice = read.nextDouble();
        read.nextLine();
        System.out.println("Maximum price: ");
        double maxPrice = read.nextDouble();
        read.nextLine();

        dealership.getVehiclesByPrice(minPrice,maxPrice);
    }

    public void processGetByMakeModelRequest(){
        System.out.println("Enter Make: ");
        String searchMake = read.nextLine();
        System.out.println("Enter model: ");
        String searchModel = read.nextLine();

        dealership.getVehiclesByMakeModel(searchMake,searchModel);
    }

    public void processGetByYearRequest(){
        System.out.println("Enter Year");
        int searchYear = read.nextInt();
        read.nextLine();

        dealership.getVehiclesByYear(searchYear);
    }
    public void processGetByColorRequest(){
        System.out.println("Enter Color");
        String searchColor = read.nextLine();

        dealership.getVehiclesByColor(searchColor);
    }
    public void processGetByMileageRequest(){
        System.out.println("Enter a mileage range: ");
        System.out.println("Enter min miles: ");
        double minMiles = read.nextDouble();
        read.nextLine();
        System.out.println("Enter max miles: ");
        double maxMiles = read.nextDouble();
        read.nextLine();

        dealership.getVehiclesByMileage(minMiles,maxMiles);
    }
    public void processGetByVehicleTypeRequest(){
        System.out.println("Enter vehicle type (car, truck, SUV, van): ");
        String searchType = read.nextLine();

    }

    public void processAddVehicleRequest(){
        System.out.println("Enter vin: ");
        int newVin = read.nextInt();
        read.nextLine();
        System.out.println("Enter year: ");
        int newYear = read.nextInt();
        read.nextLine();
        System.out.println("Enter make: ");
        String newMake = read.nextLine();
        System.out.println("Enter model: ");
        String newModel = read.nextLine();
        System.out.println("Enter vehicleType: ");
        String newVehicleType = read.nextLine();
        System.out.println("Enter color: ");
        String newColor = read.nextLine();
        System.out.println("Enter current miles: ");
        int newOdometer = read.nextInt();
        read.nextLine();
        System.out.println("Enter price: ");
        double newPrice = read.nextDouble();
        read.nextLine();

        Vehicle newVehicle = new Vehicle(newVin,newYear,newMake,newModel,newVehicleType,newColor,newOdometer,newPrice);
        dealership.addVehicle(newVehicle);
        /*
        private int vin;
        private int year;
        private String make;
        private String model;
        private String vehicleType;
        private String color;
        private int odometer;
        private double price;
         */
    }

    public void processRemoveVehicleRequest(){
        System.out.println("Enter vin of vehicle to remove: ");

        double searchVin = read.nextDouble();
        read.nextLine();
        Optional<Vehicle> vehicleToRemove = dealership.getVehicleByVin(searchVin);
        vehicleToRemove.ifPresentOrElse(
                v -> {
                    dealership.removeVehicle(v);
                    System.out.println("Vehicle" + v.getVin() + "removed from inventory.");
                    dfm.saveDealership(dealership);
                },
                () -> System.out.println("Could not find vehicle with a matching vin.")
        );
    }

    public Dealership getDealership(){
        return this.dealership;
    }
}
