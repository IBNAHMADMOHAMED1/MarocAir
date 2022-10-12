package com.marocair.models.table;

import java.util.Date;

public class TableFlight {


    public int getFlight_id() {
        return flight_id;
    }

    public int getDeparture_airport_id() {
        return departure_airport_id;
    }

    public int getArrival_airport_id() {
        return arrival_airport_id;
    }

    public int getFight_number() {
        return fight_number;
    }

    public int getFlight_max_capacity() {
        return flight_max_capacity;
    }

    public Date getDeparture_time() {
        return departure_time;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    private int flight_id;
    private int departure_airport_id;
    private int arrival_airport_id;
    private int fight_number;
    private int flight_max_capacity;
    private Date departure_time;
    private Date arrival_time;
    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public void setDeparture_airport_id(int departure_airport_id) {
        this.departure_airport_id = departure_airport_id;
    }

    public void setArrival_airport_id(int arrival_airport_id) {
        this.arrival_airport_id = arrival_airport_id;
    }

    public void setFight_number(int fight_number) {
        this.fight_number = fight_number;
    }

    public void setFlight_max_capacity(int flight_max_capacity) {
        this.flight_max_capacity = flight_max_capacity;
    }

    public void setDeparture_time(Date departure_time) {
        this.departure_time = departure_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }


}
