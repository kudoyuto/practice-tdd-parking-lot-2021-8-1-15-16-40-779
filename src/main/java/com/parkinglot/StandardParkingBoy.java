package com.parkinglot;

import java.util.List;

public class StandardParkingBoy {

    public void setParkingLot(List<ParkingLot> parkingLots){
        this.parkingLots = parkingLots;
    }
    private List<ParkingLot> parkingLots;

    public ParkingTicket park(Car car) {
        return getAvailableParkingLot().park(car);
    }
    public ParkingLot getAvailableParkingLot() {
        return parkingLots.stream()
                .filter(ParkingLot::isParkingFull)
                .findFirst()
                .orElseThrow(NoAvailablePositionException::new);
    }
    public Car fetch(ParkingTicket parkingTicket) {
        return findParkingLotRelatedTo(parkingTicket).fetch(parkingTicket);
    }
    private ParkingLot findParkingLotRelatedTo(ParkingTicket parkingTicket){
        return parkingLots.stream()
                .filter(parkingLot -> parkingLot.isRelatedTo(parkingTicket))
                .findFirst()
                .orElseThrow(UnrecognizedParkingTicketException::new);
    }


}
