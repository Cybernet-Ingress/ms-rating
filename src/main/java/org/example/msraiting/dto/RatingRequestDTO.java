package org.example.msraiting.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RatingRequestDTO {
    private Long productId;
    private Long userId;
    private int rating;
}
