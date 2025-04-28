package org.example.vehicletype;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    protected String licensePlate;
    protected VehicleType type;
}
