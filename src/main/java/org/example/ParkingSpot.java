package org.example;

import lombok.Getter;
import org.example.vehicletype.Vehicle;
import org.example.vehicletype.VehicleType;


@Getter
public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private  Vehicle parkedVehicle;



    public ParkingSpot(int spotNumber,VehicleType vehicleType){
        this.spotNumber=spotNumber;
        this.vehicleType=vehicleType;
    }

    public synchronized boolean isAvailable(){
        return parkedVehicle==null;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(isAvailable() && vehicle.getType()==vehicleType){
            parkedVehicle=vehicle;
        }else{
            throw new  IllegalArgumentException("Invalid vehicle type or spot is already occupied");
        }
    }

    public synchronized void unParkVehicle(){
        parkedVehicle=null;
    }



}
