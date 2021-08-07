package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private Car car;
    private Map<ParkingTicket,Car> parkedPositions = new HashMap<>();

    public ParkingTicket park(Car car){
        if(parkedPositions.size() == 10){
            return null;
        }
        ParkingTicket parkingTicket =  new ParkingTicket();
        this.car = car;
        parkedPositions.put(parkingTicket,car);
        return parkingTicket;
    }
    public Car fetch(ParkingTicket parkingTicket){
        Car car = parkedPositions.get(parkingTicket);
         parkedPositions.remove(parkingTicket);
         return car;
    }
}
