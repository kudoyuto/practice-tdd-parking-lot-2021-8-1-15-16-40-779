package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private Car car;
    private Map<ParkingTicket,Car> parkedPositions = new HashMap<>();
    private int parking_maximum_capacity =10;

    public ParkingTicket park(Car car){

        if(parkedPositions.size() >= parking_maximum_capacity){
            throw new NoAvailablePositionException();
        }
        ParkingTicket parkingTicket =  new ParkingTicket();
        this.car = car;
        parkedPositions.put(parkingTicket,car);
        return parkingTicket;


    }
    public Car fetch(ParkingTicket parkingTicket){
        if(isTicketRecognized(parkingTicket)){
            throw new UnrecognizedParkingTicketException();
        }

         final Car car = parkedPositions.get(parkingTicket);

         parkedPositions.remove(parkingTicket);
         return car;
    }
    public Boolean isTicketRecognized(ParkingTicket parkingTicket){

        return !parkedPositions.containsKey(parkingTicket);
    }
    public static Boolean isParkingFull(ParkingLot parkingLot){
    return   parkingLot.parkedPositions.size() <= parkingLot.parking_maximum_capacity;
    }
}
