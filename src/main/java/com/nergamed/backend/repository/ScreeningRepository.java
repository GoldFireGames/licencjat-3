package com.nergamed.backend.repository;

import com.nergamed.backend.model.Screening;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ScreeningRepository extends MongoRepository<Screening, String> {
    List<Screening> findByMovieId(String movieId);
}