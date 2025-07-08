package com.personal.project.firstday.service;

import com.personal.project.firstday.mapper.ReviewMapper;
import com.personal.project.firstday.model.dto.ReviewDto;
import com.personal.project.firstday.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ReviewService {

    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDto> getAllReviews(Pageable pageable) {
        return reviewMapper.fromEntityToDto(reviewRepository.findAll(pageable).getContent());
    }

    @Transactional
    public void createReview(ReviewDto reviewDto) {
        if (reviewDto == null) {
            throw new IllegalArgumentException("Review cannot be null");
        } else {
            reviewRepository.save(reviewMapper.fromDtoToEntity(reviewDto));
        }
    }

    public void updateReview(ReviewDto reviewDto) {
        if (reviewDto == null) {
            throw new IllegalArgumentException("Review cannot be null");
        } else {
            reviewRepository.save(reviewMapper.fromDtoToEntity(reviewDto));
        }
    }

    public void deleteReview(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Review id cannot be null");
        }
        reviewRepository.deleteById(id);
    }
}
