package com.marocair.controller;

import com.marocair.models.model.Price;

import java.sql.SQLException;
import java.util.List;

public class PriceController {

    public List<Price> getPrices() throws SQLException {
        Price price = new Price();
        return price.getAllPrice();
    }
}
