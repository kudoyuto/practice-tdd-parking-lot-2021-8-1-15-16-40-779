package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private Car car;
    private Map<ParkingTicket,Car> parkedPositions = new HashMap<>();
    private final int parking_maximum_capacity = 10;

    public ParkingTicket park(Car car){

        if(isParkingFull()){
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
    public Boolean isParkingFull(){
    return parkedPositions.size() >= parking_maximum_capacity;
    }
}
