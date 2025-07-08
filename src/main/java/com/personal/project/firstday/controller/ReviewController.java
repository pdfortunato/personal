package com.personal.project.firstday.controller;

import com.personal.project.firstday.mapper.ReviewMapper;
import com.personal.project.firstday.model.dto.ReviewDto;
import com.personal.project.firstday.repository.ReviewRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewController(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @GetMapping
    public List<ReviewDto> getAll(Pageable pageable) {
        return reviewMapper.fromEntityToDto(reviewRepository.findAll(pageable).getContent());
    }

    @PostMapping
    public void addReview(@Valid @RequestBody ReviewDto reviewDto) {
        reviewRepository.save(reviewMapper.fromDtoToEntity(reviewDto));
    }

    @PutMapping
    public void updateReview(@Valid @RequestBody ReviewDto reviewDto) {
        reviewRepository.save(reviewMapper.fromDtoToEntity(reviewDto));
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable String id) {
        reviewRepository.deleteById(id);
    }
}
