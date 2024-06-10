package org.example.msraiting.controller;

import org.example.msraiting.dto.RatingDTO;
import org.example.msraiting.dto.RatingRequestDTO;
import org.example.msraiting.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<RatingDTO> addRating(@RequestBody RatingRequestDTO ratingRequestDTO) {
        RatingDTO savedRating = ratingService.addRating(ratingRequestDTO);
        return ResponseEntity.ok(savedRating);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<RatingDTO>> getRatingsByProductId(@PathVariable Long productId) {
        List<RatingDTO> ratings = ratingService.getRatingsByProductId(productId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RatingDTO>> getRatingsByUserId(@PathVariable Long userId) {
        List<RatingDTO> ratings = ratingService.getRatingsByUserId(userId);
        return ResponseEntity.ok(ratings);
    }

    @GetMapping("/product/{productId}/average")
    public ResponseEntity<Double> getAverageRatingByProductId(@PathVariable Long productId) {
        double averageRating = ratingService.getAverageRatingByProductId(productId);
        return ResponseEntity.ok(averageRating);
    }
}
