package org.example.msraiting.service;

import org.example.msraiting.dto.RatingRequestDTO;
import org.example.msraiting.dto.RatingDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service
public class RatingService {

    @Autowired
    private RatingServiceHandler ratingServiceHandler;

    public RatingDTO addRating(RatingRequestDTO ratingRequestDTO) {
        return ratingServiceHandler.addRating(ratingRequestDTO);
    }

    public List<RatingDTO> getRatingsByProductId(Long productId) {
        return ratingServiceHandler.getRatingsByProductId(productId);
    }

    public List<RatingDTO> getRatingsByUserId(Long userId) {
        return ratingServiceHandler.getRatingsByUserId(userId);
    }

    public double getAverageRatingByProductId(Long productId) {
        return ratingServiceHandler.getAverageRatingByProductId(productId);
    }
}