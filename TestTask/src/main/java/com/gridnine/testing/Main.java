package com.gridnine.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        printFlight(flights);
        System.out.println("Выберите фильтр: 1- Исключить перелеты, где вылет до текущего момента времени.\n" +
                "2-Исключить перелеты, где имеются сегменты с датой прилета раньше даты вылета.\n"+
                "3-Исключить перелеты, где общее время, проведённое на земле превышает два часа. ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FlightFilter flightFilter = new FlightFilter();
        try {
            String filterValue = reader.readLine();
            if (filterValue.equals("1")) {
                flightFilter.departureBeforeRequestedDate(flights, LocalDateTime.now());
                printFlight(flights);
            }
            if (filterValue.equals("2")) {
                flightFilter.arrivalBeforeDeparture(flights);
                printFlight(flights);
            }
            if (filterValue.equals("3")) {
                flightFilter.groundTimeMoreThanTwoHours(flights);
                printFlight(flights);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printFlight(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
}

