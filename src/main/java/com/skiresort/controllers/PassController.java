package com.skiresort.controllers;

import com.skiresort.models.Pass;
import com.skiresort.models.PassWithPrice;
import com.skiresort.services.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/passes")
public class PassController {
    @Autowired
    private PassService passService;

    @GetMapping(value = "/id/{passId}", produces = "application/json")
    public PassWithPrice getPass(@PathVariable String passId) {
        return passService.getPassWithPriceById(passId).orElse(null);
    }

    @PostMapping(value = "/new")
    public void newPass(@RequestBody Pass pass) {
        passService.createNewPass(pass);
    }

    @GetMapping(value = "/user/{username}")
    public List<PassWithPrice> getAllPassesForUser(@PathVariable String username) {
        return passService.getAllPassesForUser(username);
    }

    @GetMapping(value = "/user/closest/{username}")
    public PassWithPrice getSoonestPassForUser(@PathVariable String username) {
        return passService.getSoonestPassForUser(username).orElse(null);
    }
}
