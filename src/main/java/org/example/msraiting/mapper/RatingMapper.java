package org.example.msraiting.mapper;

import org.example.msraiting.dto.RatingDTO;
import org.example.msraiting.dto.RatingRequestDTO;
import org.example.msraiting.dao.entity.Rating;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper {
    public RatingDTO toRatingDTO(Rating rating) {
        RatingDTO ratingDTO = new RatingDTO();
        ratingDTO.setId(rating.getId());
        ratingDTO.setProductId(rating.getProductId());
        ratingDTO.setUserId(rating.getUserId());
        ratingDTO.setRating(rating.getRating());
        return ratingDTO;
    }

    public Rating toRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = new Rating();
        rating.setProductId(ratingRequestDTO.getProductId());
        rating.setUserId(ratingRequestDTO.getUserId());
        rating.setRating(ratingRequestDTO.getRating());
        return rating;
    }
}
