package com.skiresort.controllers;

import com.skiresort.models.Pass;
import com.skiresort.services.PassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/passes")
public class PassController {
    @Autowired
    private PassService passService;

    @GetMapping(value = "/{passId}", produces = "application/json")
    public Pass getPass(@PathVariable String passId) {
        return passService.getPassById(passId).orElse(null);
    }

    @PostMapping(value = "new")
    public void newPass(Pass pass) {
        passService.createNewPass(pass);
    }
}
