package com.marocair.models.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Price {
    int price_id;
    String price_class;
    double price_value;

    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public String getPrice_class() {
        return price_class;
    }

    public void setPrice_class(String price_class) {
        this.price_class = price_class;
    }

    public double getPrice_value() {
        return price_value;
    }

    public void setPrice_value(double price_value) {
        this.price_value = price_value;
    }

    public List<Price> getAllPrice() throws SQLException {
        String sql = "SELECT * FROM price";
        Model model = new Model();
        ResultSet resultSet = model.query(sql);
        List<Price> prices = new ArrayList<>();
        while (resultSet.next()) {
            Price price = new Price();
            price.setPrice_id(resultSet.getInt(1));
            price.setPrice_class(resultSet.getString(2));
            price.setPrice_value(resultSet.getInt(3));

            prices.add(price);
        }
        return prices;

    }


}
