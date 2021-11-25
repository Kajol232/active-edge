package com.example.muhammad.stockapp.repositories;

import com.example.muhammad.stockapp.model.Stock;
import org.springframework.data.repository.CrudRepository;

public interface StockRepository extends CrudRepository<Stock, Long> {
}
