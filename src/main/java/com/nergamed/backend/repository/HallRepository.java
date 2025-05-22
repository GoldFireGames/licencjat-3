package com.nergamed.backend.repository;

import com.nergamed.backend.model.Hall;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface HallRepository extends MongoRepository<Hall, String> {
}
