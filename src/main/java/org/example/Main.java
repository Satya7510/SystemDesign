package org.example;

import org.example.vehicletype.Car;
import org.example.vehicletype.Motorcycle;
import org.example.vehicletype.Truck;
import org.example.vehicletype.Vehicle;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot=ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1,100));
        parkingLot.addLevel(new Level(1,80));
        Vehicle car=new Car("ABC123");
        Vehicle truck=new Truck("XYZ789");
        Vehicle motorcycle=new Motorcycle("M123");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorcycle);
        parkingLot.parkVehicle(truck);


        parkingLot.displayAvailability();

        parkingLot.unparkVehicle(motorcycle);

        parkingLot.displayAvailability();

    }
}