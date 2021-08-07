package com.parkinglot;

public class StandardParkingBoy {

    public void setParkingLot(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    private ParkingLot parkingLot;

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }
    public Car fetch(ParkingTicket parkingTicket) {
        return null;
    }
}
