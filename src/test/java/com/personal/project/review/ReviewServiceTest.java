package com.personal.project.review;

import com.personal.project.firstday.model.dto.ReviewDto;
import com.personal.project.firstday.model.Review;
import com.personal.project.firstday.mapper.ReviewMapper;
import com.personal.project.firstday.repository.ReviewRepository;
import com.personal.project.firstday.service.ReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReviewServiceTest {

    private ReviewService reviewService;
    private ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper = Mappers.getMapper(ReviewMapper.class);

    @BeforeEach
    void setUp() {
        reviewRepository = mock(ReviewRepository.class);
        reviewService = new ReviewService(reviewRepository, reviewMapper);
    }

    @Test
    void shouldGetAllReviewsWithPagination() {
        Review review = new Review();
        review.setId("r1");
        review.setAuthor("Paolo");
        review.setComment("Ottimo");

        PageImpl<Review> page = new PageImpl<>(List.of(review));
        when(reviewRepository.findAll(any(PageRequest.class))).thenReturn(page);

        List<ReviewDto> result = reviewService.getAllReviews(PageRequest.of(0, 10));

        assertEquals(1, result.size());
        assertEquals("Paolo", result.get(0).getAuthor());
    }

    @Test
    void shouldSaveReview() {
        ReviewDto dto = new ReviewDto();
        dto.setAuthor("Alessia");
        dto.setComment("Benissimo");

        reviewService.createReview(dto);

        verify(reviewRepository, times(1)).save(any(Review.class));
    }

    @Test
    void shouldUpdateReview() {
        ReviewDto dto = new ReviewDto();
        dto.setId("idUpdate");
        dto.setAuthor("Update");
        dto.setComment("Contenuto aggiornato");

        reviewService.updateReview(dto);

        verify(reviewRepository, times(1)).save(any(Review.class));
    }

    @Test
    void shouldDeleteReview() {
        String id = "del123";

        reviewService.deleteReview(id);

        verify(reviewRepository, times(1)).deleteById(id);
    }
}
