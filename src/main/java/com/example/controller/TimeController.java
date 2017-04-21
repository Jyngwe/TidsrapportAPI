package com.example.controller;

import com.example.database.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @Autowired
    DBManager manager;

    @GetMapping("/test")
    public String getTestTime() {
        manager.listUsers();
        return "hej";
    }
}
