package com.example.muhammad.stockapp.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double current_price;
    @CreationTimestamp
    private LocalDateTime create_date;
    @UpdateTimestamp
    public LocalDateTime last_update;

    public Stock() {
    }

    public Stock(String name, double current_price) {
        this.name = name;
        this.current_price = current_price;
    }

    public long getId() {
        return id;
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

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }
}
