package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardParkingBoyTest {
//    @Test
//    void should_return_parking_ticket_when_park_given_a_parking_lot_standard_parking_boy_and_a_car() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        StandardParkingBoy parkingBoy = new StandardParkingBoy();
//        parkingBoy.setParkingLot(parkingLot);
//        Car car = new Car();
//        //when
//        ParkingTicket parkingTicket= parkingBoy.park(car);
//
//        //then
//        assertNotNull(parkingTicket);
//    }
//    @Test
//    void should_return_car_when_fetch_given_a_parking_lot_standard_parking_boy_and_a_parking_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        StandardParkingBoy parkingBoy = new StandardParkingBoy();
//        parkingBoy.setParkingLot(parkingLot);
//        Car car = new Car();
//        ParkingTicket parkingTicket = parkingBoy.park(car);
//
//        //when
//        Car actualCar = parkingBoy.fetch(parkingTicket);
//
//        //then
//        assertNotNull(actualCar);
//    }
//    @Test
//    void should_return_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_standard_parking_boy_and_two_parking_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        StandardParkingBoy parkingBoy = new StandardParkingBoy();
//        parkingBoy.setParkingLot(parkingLot);
//        Car car = new Car();
//        Car car2 = new Car();
//        ParkingTicket parkingTicket1 = parkingBoy.park(car);
//        ParkingTicket parkingTicket2 = parkingBoy.park(car2);
//
//        //when
//        Car actualCar = parkingBoy.fetch(parkingTicket1);
//        Car actualCar2 = parkingBoy.fetch(parkingTicket2);
//
//        //then
//        assertEquals(car, actualCar);
//        assertEquals(car2, actualCar2);
//    }
//    @Test
//    void should_return_exception_error_message_unrecognized_ticket_when_fetch_given_a_parking_lot_standard_parking_boy_and_wrong_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        StandardParkingBoy parkingBoy = new StandardParkingBoy();
//        parkingBoy.setParkingLot(parkingLot);
//
//        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();
//
//        //when
//        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(unrecognizedParkingTicket));
//        //then
//        assertEquals("Unrecognized parking ticket", exception.getMessage());
//    }
//    @Test
//    void should_return_exception_error_unrecognized_parking_ticket_when_fetch_given_a_parking_lot_standard_parking_boy_and_used_ticket() {
//        //given
//        ParkingLot parkingLot = new ParkingLot();
//        StandardParkingBoy parkingBoy = new StandardParkingBoy();
//        parkingBoy.setParkingLot(parkingLot);
//        Car car = new Car();
//        ParkingTicket parkingTicket = parkingBoy.park(car);
//        Car actualFirstCar = parkingBoy.fetch(parkingTicket);
//
//        //when
//        Exception exception = assertThrows(UnrecognizedParkingTicketException.class, () -> parkingBoy.fetch(parkingTicket));
//
//        //then
//        assertEquals("Unrecognized parking ticket", exception.getMessage());
//    }
//    @Test
//    void should_return_exception_with_no_available_position_when_park_given_a_parking_lot_without_any_position_standard_parking_and_car() {
//        //given
//        int parking_maximum_capacity = 10;
//        ParkingLot parkingLot = new ParkingLot();
//        StandardParkingBoy parkingBoy = new StandardParkingBoy();
//        parkingBoy.setParkingLot(parkingLot);
//        Car car = new Car();
//
//        for (int i = 0; i < parking_maximum_capacity; i++) {
//            parkingBoy.park(new Car());
//        }
//
//        //when
//        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingBoy.park(car));
//
//        //then
//        assertEquals("No available position", exception.getMessage());
//    }

    @Test
    void should_return_park_in_the_first_parking_lot_when_park_given_two_parking_lots_and_standard_parking_boy_and_a_car() {
        //given
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(10), new ParkingLot(10));
        StandardParkingBoy parkingBoy = new StandardParkingBoy();
        parkingBoy.setParkingLot(parkingLots);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertEquals(car, parkingLots.get(0).fetch(parkingTicket));
    }
    @Test
    void should_return_park_in_the_second_parking_lot_when_park_given_standard_parking_boy_with_two_parking_lots_first_is_full_and_second_with_available_position_and_a_car() {
        //given
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(10), new ParkingLot(10));
        StandardParkingBoy parkingBoy = new StandardParkingBoy();
        parkingBoy.setParkingLot(parkingLots);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertEquals(car, parkingLots.get(1).fetch(parkingTicket));
    }
    @Test
    void should_return_the_right_car_with_each_ticket_when_fetch_given_a_standard_parking_boy_with_two_parking_lots_both_with_a_parked_car_and_two_tickets() {
        //given
        List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(), new ParkingLot());
        StandardParkingBoy parkingBoy = new StandardParkingBoy();
        parkingBoy.setParkingLot(parkingLots);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket firstParkingTicket = parkingBoy.park(car1);
        ParkingTicket secondParkingTicket = parkingBoy.park(car2);

        //when
        Car firstActualCar = parkingBoy.fetch(firstParkingTicket);
        Car secondActualCar = parkingBoy.fetch(secondParkingTicket);

        //then
        assertEquals(car1, firstActualCar);
        assertEquals(car2, secondActualCar);
    }
}

