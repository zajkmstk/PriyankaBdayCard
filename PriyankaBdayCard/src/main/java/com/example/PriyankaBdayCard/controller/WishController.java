package com.example.PriyankaBdayCard.controller;


import com.example.PriyankaBdayCard.entities.Wish;
import com.example.PriyankaBdayCard.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api")

public class WishController {
    private WishService service;

    public WishController(@Autowired WishService service) {
        this.service = service;
    }

    @GetMapping("/wishes")
    public ResponseEntity<List<Wish>> getAllWishes(){
        return ResponseEntity.ok(service.findAll());
    }


}
