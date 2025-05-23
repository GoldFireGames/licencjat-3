package com.nergamed.backend.service;

import com.nergamed.backend.model.Screening;
import com.nergamed.backend.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ScreeningService {

    @Autowired
    private ScreeningRepository repository;

    public Screening createScreening(Screening screening) {
        return repository.save(screening);
    }

    public List<Screening> getAllScreenings() {
        return repository.findAll();
    }


    // Zmieniamy na zwracanie List<Screening> bez Optional, bo łatwiej obsłużyć w kontrolerze
    public List<Screening> getScreeningsByMovieId(String movieId) {
        return repository.findByMovieId(movieId);
    }

    public Optional<Screening> getScreeningById(String id) {
        return repository.findById(id);
    }

    public Optional<List<String>> getOccupiedSeats(String id) {
        return repository.findById(id).map(Screening::getOccupiedSeats);
    }

    public Optional<Screening> addOccupiedSeats(String id, List<String> newSeats) {
        return repository.findById(id).map(screening -> {
            List<String> occupied = screening.getOccupiedSeats();
            if (occupied == null) {
                occupied = new ArrayList<>();
            }
            for (String seat : newSeats) {
                if (!occupied.contains(seat)) {
                    occupied.add(seat);
                }
            }
            screening.setOccupiedSeats(occupied);
            return repository.save(screening);
        });
    }
}
