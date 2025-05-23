package com.nergamed.backend.controller;

import com.nergamed.backend.dto.UpdateOccupiedSeatsRequest;
import com.nergamed.backend.model.Screening;
import com.nergamed.backend.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {

    @Autowired
    private ScreeningService service;

    @PostMapping
    public ResponseEntity<Screening> createScreening(@RequestBody Screening screening) {
        return ResponseEntity.status(201).body(service.createScreening(screening));
    }

    // Parametr movieId jest opcjonalny
    @GetMapping
    public List<Screening> getScreenings(@RequestParam(required = false) String movieId) {
        if (movieId != null && !movieId.isEmpty()) {
            return service.getScreeningsByMovieId(movieId);
        } else {
            return service.getAllScreenings();
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Screening> getById(@PathVariable String id) {
        return service.getScreeningById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/occupied-seats")
    public ResponseEntity<List<String>> getOccupiedSeats(@PathVariable String id) {
        return service.getOccupiedSeats(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/occupied-seats")
    public ResponseEntity<Screening> addOccupiedSeats(
            @PathVariable String id,
            @RequestBody UpdateOccupiedSeatsRequest request) {
        return service.addOccupiedSeats(id, request.getSeats())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
