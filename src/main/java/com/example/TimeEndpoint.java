package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niklas.pettersson on 2017-04-19.
 */
@RestController
public class TimeEndpoint {

    @GetMapping("/test")
    public String getTestTime() {
        return "hej";
    }
}
