package com.gridnine.testing;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


import java.util.ArrayList;
import java.util.List;

class FlightFilterTest{

    List<Flight> testFlights;
    FlightFilter flightFilter = new FlightFilter();

    @BeforeEach
    void setUp() {
        testFlights = FlightTestData.getList();
    }

    @AfterEach
    void tearDown() {
        testFlights = null;
    }

    @Test
    public void departureBeforeRequestedDate(){
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = flightFilter.departureBeforeRequestedDate(testFlights, FlightTestData.requestedDate);
        expected.remove(1);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void arrivalBeforeDeparture() {
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = flightFilter.arrivalBeforeDeparture(testFlights);
        expected.remove(4);
        Assertions.assertIterableEquals(expected, actual);
    }

    @Test
    public void groundTimeMoreThanTwoHours() {
        List<Flight> expected = new ArrayList<>(testFlights);
        List<Flight> actual = flightFilter.groundTimeMoreThanTwoHours(testFlights);
        expected.remove(3);
        Assertions.assertIterableEquals(expected, actual);
    }
}