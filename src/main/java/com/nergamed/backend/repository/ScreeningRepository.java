package com.nergamed.backend.repository;

import com.nergamed.backend.model.Screening;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScreeningRepository extends MongoRepository<Screening, String> {
}
