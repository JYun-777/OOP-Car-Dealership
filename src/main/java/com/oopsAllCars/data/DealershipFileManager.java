package com.oopsAllCars.data;

import com.oopsAllCars.model.Dealership;
import com.oopsAllCars.model.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DealershipFileManager {

    public Dealership getDealership(){
        try{
            FileReader fr = new FileReader("src/main/resources/inventory.csv");
            BufferedReader br = new BufferedReader(fr);

            String dealerShipInfo = br.readLine();


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
            throw new RuntimeException(e);
        }
    }

    //save to file
    public static void saveDealership(Dealership dealership){

    }
}
