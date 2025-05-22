package com.nergamed.backend.service;

import com.nergamed.backend.model.Hall;
import com.nergamed.backend.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {

    private final HallRepository hallRepository;

    @Autowired
    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    //read all
    public List<Hall> getHalls() {
        return hallRepository.findAll();
    }

    public Hall getHallById(String id) {
        return hallRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hall not found"));
    }

}
