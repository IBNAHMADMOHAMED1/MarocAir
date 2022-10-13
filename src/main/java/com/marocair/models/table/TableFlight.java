package com.marocair.models.table;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class TableFlight {
    private int flight_id;
    private int airline_id;
    private int price_id;
    private String airline_name;
    private String flight_number;
    private String departure_airport_name;
    private int departure_airport_id;
    private String arrival_airport_name;
    private int arrival_airport_id;
    private String departure_time;
    private String arrival_time;
    private int flight_max_capacity;
    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }


    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getAirline_id() {
        return airline_id;
    }

    public void setAirline_id(int airline_id) {
        this.airline_id = airline_id;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getDeparture_airport_name() {
        return departure_airport_name;
    }

    public void setDeparture_airport_name(String departure_airport_name) {
        this.departure_airport_name = departure_airport_name;
    }

    public int getDeparture_airport_id() {
        return departure_airport_id;
    }

    public void setDeparture_airport_id(int departure_airport_id) {
        this.departure_airport_id = departure_airport_id;
    }

    public String getArrival_airport_name() {
        return arrival_airport_name;
    }

    public void setArrival_airport_name(String arrival_airport_name) {
        this.arrival_airport_name = arrival_airport_name;
    }

    public int getArrival_airport_id() {
        return arrival_airport_id;
    }

    public void setArrival_airport_id(int arrival_airport_id) {
        this.arrival_airport_id = arrival_airport_id;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getFlight_max_capacity() {
        return flight_max_capacity;
    }

    public void setFlight_max_capacity(int flight_max_capacity) {
        this.flight_max_capacity = flight_max_capacity;
    }

    // INSERT INTO Flight(flight_id,airline_id, flight_number, departure_airport_id, arrival_airport_id, departure_time, arrival_time, flight_max_capacity, flight_price_id) VALUES (1,1,'AF 001',1,2,'2019-01-01 00:00:00','2019-01-01 00:00:00',100,1);


}
