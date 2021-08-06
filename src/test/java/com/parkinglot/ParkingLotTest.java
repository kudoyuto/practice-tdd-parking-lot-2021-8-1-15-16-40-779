package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ParkingLotTest {
    @Test
    void return_parking_ticket_when_park_given_parking_lot_and_a_car(){
        //Given
        Car car =new Car();
        ParkingLot parkingLot = new ParkingLot();
        //When
        ParkingTicket parkingTicket = parkingLot.park(car);
        ///Then
        assertNotNull(parkingTicket);
    }
    @Test
    void return_parked_car_when_fetch_given_parking_lot_with_park_car_and_parking_ticket(){
        //Given
        Car car =new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.park(car);
        //When
        Car actualCar = parkingLot.fetch(parkingTicket);
        ///Then
        assertEquals(car,actualCar);
    }
    @Test
    void return_correct_car_when_fetch_the_car_twice_lot_given_a_parking_lot_with_a_parked_car_and_parking_ticket(){
        //Given
        Car car =new Car();
        Car car2 = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket car1ParkingTicket = parkingLot.park(car);
        ParkingTicket car2ParkingTicket = parkingLot.park(car2);
        //When
        Car actualCar = parkingLot.fetch(car1ParkingTicket);
        Car actualCar2 = parkingLot.fetch(car2ParkingTicket);
        ///Then
        assertEquals(car,actualCar);
        assertEquals(car2,actualCar2);
    }
}
