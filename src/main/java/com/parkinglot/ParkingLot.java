package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private Car car;
    private Map<ParkingTicket,Car> parkedPositions = new HashMap<>();
    private static final int parking_maximum_capacity =10;
    private int parkingCapacity;
    public ParkingLot() {
        this(parking_maximum_capacity);
    }
    public ParkingLot(int capacity){
        this.parkingCapacity = capacity;
    }

    public ParkingTicket park(Car car){


        ParkingTicket parkingTicket =  new ParkingTicket();
        this.car = car;
        parkedPositions.put(parkingTicket,car);
        return parkingTicket;


    }
    public Car fetch(ParkingTicket parkingTicket){


         final Car car = parkedPositions.get(parkingTicket);

         parkedPositions.remove(parkingTicket);
         return car;
    }

    public static Boolean isParkingFull(ParkingLot parkingLot){
    return  parkingLot.parkedPositions.size() < parkingLot.parkingCapacity;
    }

    public boolean isRelatedTo(ParkingTicket parkingTicket) {
        return parkedPositions.containsKey(parkingTicket);
    }
}
