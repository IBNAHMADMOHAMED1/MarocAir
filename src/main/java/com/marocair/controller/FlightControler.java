package com.marocair.controller;


import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.marocair.models.model.Airline;
import com.marocair.models.model.Flight;
import com.marocair.models.table.TableFlight;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
public class FlightControler {
    private static String message;
    private static Flight flight = new Flight();

    private static TableFlight tableFlight = new TableFlight();



    public void init() {

    }


}
