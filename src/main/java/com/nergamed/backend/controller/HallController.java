package com.nergamed.backend.controller;

import com.nergamed.backend.model.Hall;
import com.nergamed.backend.service.HallService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/halls")
public class HallController {

    private final HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping
    public ResponseEntity<List<Hall>> getAllHalls() {
        return ResponseEntity.ok(hallService.getHalls());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hall> getHallById(@PathVariable String id) {
        try{
            return ResponseEntity.ok(hallService.getHallById(id));
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
