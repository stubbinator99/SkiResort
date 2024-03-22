package com.skiresort.controllers;

import com.skiresort.models.Price;
import com.skiresort.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping(value = "/id/{priceId}", produces = "application/json")
    public Price getPrice(@PathVariable int priceId) {
        return priceService.getPriceById(priceId).orElse(null);
    }

    @PostMapping(value = "/new")
    public void newPrice(@RequestBody Price price) {
        priceService.createNewPrice(price);
    }

    @GetMapping(value = "/all")
    public List<Price> getPricesForCurrentSeason() {
        return priceService.getPricesForCurrentSeason();
    }
}
