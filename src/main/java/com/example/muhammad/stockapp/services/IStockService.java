package com.example.muhammad.stockapp.services;

import com.example.muhammad.stockapp.model.Stock;
import com.example.muhammad.stockapp.model.StockDTO;

import java.util.List;

public interface IStockService {
    List<Stock> getStocks();
    Stock getStockById(long id);
    Stock addStock(StockDTO stockDTO);
    boolean updateStock(long id, double price);
    boolean updateStock(long id, String name);
    void deleteStock(long id);


}
