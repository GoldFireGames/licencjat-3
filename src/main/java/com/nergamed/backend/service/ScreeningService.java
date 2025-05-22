package com.nergamed.backend.service;

import com.nergamed.backend.model.Screening;
import com.nergamed.backend.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;

    public List<Screening> allScreenings(){
        return screeningRepository.findAll();
    }

    public Screening getScreeningById(@PathVariable String id) {
        return screeningRepository.findById(id).get();
    }

}
