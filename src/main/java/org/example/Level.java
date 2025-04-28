package org.example;

import org.example.vehicletype.Vehicle;
import org.example.vehicletype.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor,int numSpot){
        this.floor=floor;
        parkingSpots=new ArrayList<>(numSpot);

        double spotsForBikes=0.5;
        double spotsForCar=0.4;

        int numBikes=(int)(numSpot*spotsForBikes);
        int numCars=(int)(numSpot*spotsForCar);

        for(int i=1;i<=numBikes;i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));

        }
        for(int i=numBikes+1;i<=numBikes+numCars;i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));

        }
        for(int i=numBikes+numCars+1;i<=numSpot;i++){
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot:parkingSpots){
            if(spot.isAvailable() && spot.getVehicleType()==vehicle.getType()){
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        for(ParkingSpot spot:parkingSpots){
            if(!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle));
            {
                spot.unParkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailibility(){
        System.out.println("Level "+floor+" Availibility : ");
        for(ParkingSpot spot : parkingSpots){
            System.out.println("Spot "+spot.getSpotNumber()+": "+(spot.isAvailable()?"Available For":"Occupied By ")+" "+spot.getVehicleType());
        }
    }

}
