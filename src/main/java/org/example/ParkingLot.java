package org.example;

import org.example.vehicletype.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level>levels;

    public ParkingLot(){
        levels=new ArrayList<>();
    }

    public static synchronized  ParkingLot getInstance(){
        if(instance==null){
            instance=new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level:levels){
            if(level.parkVehicle(vehicle)){
                System.out.println("Vechile parked Successfully.");
                return true;
            }
        }
        System.out.println("Could not park vehicle");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(Level level:levels){
            if(level.unParkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(Level level : levels){
            level.displayAvailibility();
        }
    }

}
