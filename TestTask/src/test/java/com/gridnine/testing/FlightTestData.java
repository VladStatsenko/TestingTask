package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;

public class FlightTestData {
    public static final LocalDateTime requestedDate = of(2020,12,25,15,0);

    public static final Segment segment1 = new Segment(of(2020,12,25,16,0),
            of(2020,12,25,18,0));

    public static final Segment segment2 = new Segment(of(2020,12,23,13,0),
            of(2020,12,25,18,0));

    public static final Segment segment3 = new Segment(of(2020,12,25,16,0),
            of(2020,12,25,18,0));

    public static final Segment segment4 = new Segment(of(2020,12,25,19,0),
            of(2020,12,25,23,0));

    public static final Segment segment5 = new Segment(of(2020,12,26,1,0),
            of(2020,12,26,10,0));

    public static final Segment segment6 = new Segment(of(2020,12,25,16,0),
            of(2020,12,25,11,0));

    // normal case
    public static final Flight flight1 = new Flight(Arrays.asList(segment1));

    // departure date is before requested date
    public static final Flight flight2 = new Flight(Arrays.asList(segment2));

    // normal case, 2 segments
    public static final Flight flight3 = new Flight(Arrays.asList(segment3, segment4));

    // ground time is more than 2 hours /
    public static final Flight flight4 = new Flight(Arrays.asList(segment3, segment4, segment5));

    // arrival dateTime is before departure dateTime
    public static final Flight flight5 = new Flight(Arrays.asList(segment6));

    public static List<Flight> getList() {
        return Arrays.asList(flight1,flight2,flight3,flight4,flight5);
    }
}
