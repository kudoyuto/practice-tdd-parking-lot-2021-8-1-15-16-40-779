package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
    @Test
    void return_parked_nothing_when_fetch_given_parking_lot_and_wrong_parking_ticket(){
        //Given
        Car car =new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        //When
        Car actualCar = parkingLot.fetch(parkingTicket);
        ///Then
        assertNull(actualCar);
    }
    @Test
    void return_parked_nothing_when_fetch_given_parking_lot_and_used_parking_ticket(){
        //Given
        Car car =new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket usedParkingTicket = parkingLot.park(car);
        Car actualCar = parkingLot.fetch(usedParkingTicket);

        //When

         Car actualCar2 = parkingLot.fetch(usedParkingTicket);
        ///Then
        assertEquals(car,actualCar);
        assertNull(actualCar2);

    }
    @Test
    void should_return_nothing_when_park_given_full_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        {
            int parkingCapacity = 10;
            while (parkingCapacity >= 0) {
                ParkingTicket carTickets = parkingLot.park((car));
                parkingCapacity--;
            }
        }
        Car newCarToPark = new Car();
        //when
        ParkingTicket newCarParkingTicket = parkingLot.park(newCarToPark);
        //then
        assertNull(newCarParkingTicket);
    }
    @Test
    void should_return_nothing_with_error_message_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_unrecognized_ticket(){
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
        //When
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(unrecognizedParkingTicket));
        //Then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_return_nothing_with_error_message_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_used_ticket(){
        //Given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = parkingLot.park(new Car ());
        parkingLot.fetch(parkingTicket);
        //When
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.fetch(parkingTicket));
        //Then
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

}
