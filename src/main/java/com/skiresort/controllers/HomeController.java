package com.skiresort.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  /*@GetMapping("/")
  public ModelAndView index() {
    return new ModelAndView("index.html");
  }*/

    //@GetMapping("/index")
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
