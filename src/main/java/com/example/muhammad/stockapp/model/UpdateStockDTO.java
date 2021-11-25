package com.example.muhammad.stockapp.model;

import com.sun.istack.Nullable;

public class UpdateStockDTO {
    @Nullable
    private String name;
    @Nullable
    private double current_price;

    public UpdateStockDTO(String name, double current_price) {
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
