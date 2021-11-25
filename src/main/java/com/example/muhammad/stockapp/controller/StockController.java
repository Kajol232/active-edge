package com.example.muhammad.stockapp.controller;

import com.example.muhammad.stockapp.model.Stock;
import com.example.muhammad.stockapp.model.StockDTO;
import com.example.muhammad.stockapp.model.UpdateStockDTO;
import com.example.muhammad.stockapp.services.StockServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    private final StockServiceImpl stockService;

    public StockController(StockServiceImpl stockService) {
        this.stockService = stockService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Stock> getStocks(){
        return stockService.getStocks();
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Stock> getStock(@PathVariable long id){
        Stock stock = stockService.getStockById(id);
        return stock != null ? new ResponseEntity<>(stock, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping ( consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addStock(@RequestBody StockDTO stockDTO){
        if(stockDTO == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Stock stock = stockService.addStock(stockDTO);
        return stock != null ? new ResponseEntity<>(stock, HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateStock(@PathVariable long id, @RequestBody UpdateStockDTO updateStockDTO){
        return stockService.updateStock(id, updateStockDTO)? new ResponseEntity<>(HttpStatus.ACCEPTED) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteStock(@PathVariable long id){
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
