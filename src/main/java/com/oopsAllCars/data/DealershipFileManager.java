package com.oopsAllCars.data;

import com.oopsAllCars.model.Dealership;
import com.oopsAllCars.model.Vehicle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership(){
        try{
            FileReader fr = new FileReader("src/main/resources/inventory.csv");
            BufferedReader br = new BufferedReader(fr);

            //first line read
            String dealerInfoLine = br.readLine();
            String[] dealerFields = dealerInfoLine.split("\\|");
            Dealership readDealership = new Dealership(dealerFields[0], dealerFields[1], dealerFields[2]);

            //read and add vehicle lines
            String vehicleLine;
            String[] datafields;
            while ((vehicleLine = br.readLine()) != null){
                datafields = vehicleLine.split("\\|");
                Vehicle newVehicle = new Vehicle(Integer.parseInt(datafields[0]),Integer.parseInt(datafields[1]),datafields[2],datafields[3],
                        datafields[4],datafields[5],Integer.parseInt(datafields[6]),Double.parseDouble(datafields[7]));
                readDealership.addVehicle(newVehicle);
            }

            return readDealership;
        } catch (Exception e) {
            System.out.println("Cannot find inventory.csv");
            throw new RuntimeException(e);
        }
    }

    //save to file
    public void saveDealership(Dealership dealership){
        try{
            FileWriter fw = new FileWriter("src/main/resources/inventory.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(dealership.getDealershipData());
            ArrayList<Vehicle> vehicleList = dealership.getInventory();
            for (Vehicle v : vehicleList){
                bw.write(v.getVehicleData());
            }
            System.out.println("Saving inventory... count: " + dealership.getInventory().size());

            bw.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
