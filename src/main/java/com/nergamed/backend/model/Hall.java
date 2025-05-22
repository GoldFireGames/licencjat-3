package com.nergamed.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "halls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hall {
    @Id
    private String id;
    private int rows;
    private int cols;
}
