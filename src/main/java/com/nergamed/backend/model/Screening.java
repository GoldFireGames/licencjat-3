package com.nergamed.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "screenings")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Screening {
    @Id
    private String id;
    private String movieId;
    private String hallId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private double baseTicketPrice;
    private List<String> occupiedSeats;
}
