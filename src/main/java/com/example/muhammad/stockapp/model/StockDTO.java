package com.example.muhammad.stockapp.model;

public class StockDTO {
    private String name;
    private double current_price;

    public StockDTO(String name, double current_price) {
        this.name = name;
        this.current_price = current_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(double current_price) {
        this.current_price = current_price;
    }
}
