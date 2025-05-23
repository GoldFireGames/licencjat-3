package com.nergamed.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class UpdateOccupiedSeatsRequest {
    private List<String> seats;
}
