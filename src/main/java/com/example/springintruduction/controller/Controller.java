package com.example.springintruduction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springintruduction.services.DayCalculator;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/echo")
    public String echo(@RequestParam String input) {
        return input;
    }

    @GetMapping("/erDetFredag")
    public String erDetFredag() {
        DayCalculator calculator = new DayCalculator();
        return calculator.isItFriday();
    }
}
