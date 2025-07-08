package com.personal.project.firstday.controller;

import com.personal.project.firstday.mapper.ReviewMapper;
import com.personal.project.firstday.model.dto.ReviewDto;
import com.personal.project.firstday.repository.ReviewRepository;
import com.personal.project.firstday.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDto> getAll(Pageable pageable) {
        return reviewService.getAllReviews(pageable);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@Valid @RequestBody ReviewDto reviewDto) {
        reviewService.createReview(reviewDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<String> updateReview(@Valid @RequestBody ReviewDto reviewDto) {
        reviewService.updateReview(reviewDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
