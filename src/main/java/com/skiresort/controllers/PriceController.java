package com.skiresort.controllers;

import com.skiresort.models.Price;
import com.skiresort.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping(value = "/{priceId}", produces = "application/json")
    public Price getPass(@PathVariable String priceId) {
        return priceService.getPriceById(priceId).orElse(null);
    }

    @PostMapping(value = "new")
    public void newPass(Price price) {
        priceService.createNewPrice(price);
    }
}
