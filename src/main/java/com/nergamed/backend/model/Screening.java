package com.nergamed.backend.model;

import com.nergamed.backend.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection="screenings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screening {

    @Id
    private String id;

    private String screeningId;

    @DBRef
    private Hall hall;

    private String startTime;
    private String endTime;
    private double basePrice;
    private List<String> occupiedSeats;
}
