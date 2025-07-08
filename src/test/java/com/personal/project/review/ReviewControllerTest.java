package com.personal.project.review;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.project.firstday.controller.ReviewController;
import com.personal.project.firstday.model.dto.ReviewDto;
import com.personal.project.firstday.mapper.ReviewMapper;
import com.personal.project.firstday.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ReviewController.class)
class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    @MockBean
    private ReviewMapper reviewMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetAllReviewsWithPagination() throws Exception {
        ReviewDto review = new ReviewDto();
        review.setId("1");
        review.setAuthor("Pasquale");
        review.setComment("Recensione valida");
        review.setUserId(1L);
        review.setProductId(1L);

        Mockito.when(reviewService.getAllReviews(any(Pageable.class)))
                .thenReturn(List.of(review));

        mockMvc.perform(get("/review")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].author").value("Pasquale"))
                .andExpect(jsonPath("$[0].comment").value("Recensione valida"));
    }

    @Test
    void shouldCreateReview() throws Exception {
        ReviewDto request = new ReviewDto();
        request.setId("rev123");
        request.setAuthor("Marco");
        request.setComment("Molto utile");
        request.setUserId(1L);
        request.setProductId(1L);

        mockMvc.perform(post("/review")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNoContent());

        Mockito.verify(reviewService).createReview(any(ReviewDto.class));
    }

    @Test
    void shouldUpdateReview() throws Exception {
        ReviewDto request = new ReviewDto();
        request.setId("rev123");
        request.setAuthor("Anna");
        request.setComment("Aggiornamento recensione");

        mockMvc.perform(put("/review")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isNoContent());

        Mockito.verify(reviewService).updateReview(any(ReviewDto.class));
    }

    @Test
    void shouldDeleteReview() throws Exception {
        String id = "abc123";

        mockMvc.perform(delete("/review/{id}", id))
                .andExpect(status().isNoContent());

        Mockito.verify(reviewService).deleteReview(id);
    }
}
