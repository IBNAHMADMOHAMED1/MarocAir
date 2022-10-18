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

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public String getHeure_arrivee() {
        return heure_arrivee;
    }

    public void setHeure_arrivee(String heure_arrivee) {
        this.heure_arrivee = heure_arrivee;
    }

    private String heure_depart;
    private String heure_arrivee;
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
        return dateFormat(departure_time);
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return dateFormat(arrival_time);
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

    public String dateFormat(String date)
    {
        System.out.println(date);
        String[] dateArray = date.split(" ");
        String[] dateArray2 = dateArray[0].split("-");
        String monthName = "";
        switch (dateArray2[1])
        {
            case "01":
                monthName = "Janvier";
                break;
            case "02":
                monthName = "Février";
                break;
            case "03":
                monthName = "Mars";
                break;
            case "04":
                monthName = "Avril";
                break;
            case "05":
                monthName = "Mai";
                break;
            case "06":
                monthName = "Juin";
                break;
            case "07":
                monthName = "Juillet";
                break;
            case "08":
                monthName = "Août";
                break;
            case "09":
                monthName = "Septembre";
                break;
            case "10":
                monthName = "Octobre";
                break;
            case "11":
                monthName = "Novembre";
                break;
            case "12":
                monthName = "Décembre";
                break;
            default:
                monthName = "Error";
                break;
        }
        return dateArray2[2] + " " + monthName + " " + dateArray2[0];

    }


}
