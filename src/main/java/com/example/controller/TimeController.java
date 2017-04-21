package com.example.controller;

import com.example.database.DBManager;
import com.google.gson.Gson;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @Autowired
    DBManager manager;

    @GetMapping("/test")
    public String getTestTime() {
        return new Gson().toJson(manager.listUsers());
    }
    @GetMapping("/times")
    public String getAllTimes() {
        return new Gson().toJson(manager.listTimes());
    }
    @GetMapping("/time/{id}")
    public String getTimeForUser(@PathVariable int id) {
        return new Gson().toJson(manager.getTimesFromUser(id));
    }
    @GetMapping("/newTime/{id}")
    public void createNewTimeStamp(@PathVariable int id) {
        manager.createTimeStamp(id);
    }
}
