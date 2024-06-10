package org.example.msraiting.service;

import org.example.msraiting.dto.RatingDTO;
import org.example.msraiting.dto.RatingRequestDTO;
import org.example.msraiting.mapper.RatingMapper;
import org.example.msraiting.dao.entity.Rating;
import org.example.msraiting.dao.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RatingServiceHandler {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingMapper ratingMapper;

    public RatingDTO addRating(RatingRequestDTO ratingRequestDTO) {
        Rating rating = ratingMapper.toRating(ratingRequestDTO);
        Rating savedRating = ratingRepository.save(rating);
        return ratingMapper.toRatingDTO(savedRating);
    }

    public List<RatingDTO> getRatingsByProductId(Long productId) {
        return ratingRepository.findByProductId(productId)
                .stream()
                .map(ratingMapper::toRatingDTO)
                .collect(Collectors.toList());
    }

    public List<RatingDTO> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId)
                .stream()
                .map(ratingMapper::toRatingDTO)
                .collect(Collectors.toList());
    }

    public double getAverageRatingByProductId(Long productId) {
        List<Rating> ratings = ratingRepository.findByProductId(productId);
        return ratings.stream().mapToInt(Rating::getRating).average().orElse(0.0);
    }
}
