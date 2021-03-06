package com.example.muhammad.stockapp.services;

import com.example.muhammad.stockapp.model.Stock;
import com.example.muhammad.stockapp.model.StockDTO;
import com.example.muhammad.stockapp.model.UpdateStockDTO;
import com.example.muhammad.stockapp.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements IStockService{
    private final StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getStocks() {
        return (List<Stock>) stockRepository.findAll();
    }

    @Override
    public Stock getStockById(long id) {
        return stockRepository.findById(id).get();
    }

    @Override
    public Stock addStock(StockDTO stockDTO) {
        Stock s = new Stock();
        s.setCurrent_price(stockDTO.getCurrent_price());
        s.setName(stockDTO.getName());
        return stockRepository.save(s);
    }

    @Override
    public boolean updateStock(long id, UpdateStockDTO stockDTO) {
        Optional<Stock> stockFromDb = stockRepository.findById(id);
        if(!stockFromDb.isPresent()){
            return false;
        }
        Stock stock = stockFromDb.get();
        if(stockDTO.getCurrent_price() != 0){
            stock.setCurrent_price(stockDTO.getCurrent_price());
        }

        if(stockDTO.getName() != null){
            stock.setName(stockDTO.getName());
        }

        stockRepository.save(stock);

        return true;
    }


    @Override
    public void deleteStock(long id) {
        Stock stock = stockRepository.findById(id).get();
        stockRepository.delete(stock);

    }
}
