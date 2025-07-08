package com.personal.project.review;

import com.personal.project.firstday.mapper.ReviewMapper;
import com.personal.project.firstday.model.dto.ReviewDto;
import com.personal.project.firstday.model.Review;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class ReviewMapperTest {

    private final ReviewMapper mapper = Mappers.getMapper(ReviewMapper.class);

    @Test
    void shouldMapEntityToDto() {
        Review entity = new Review();
        entity.setId("abc123");
        entity.setAuthor("Pasquale");
        entity.setComment("Ottimo prodotto!");

        ReviewDto dto = mapper.fromEntityToDto(entity);

        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getAuthor(), dto.getAuthor());
        assertEquals(entity.getComment(), dto.getComment());
    }

    @Test
    void shouldMapDtoToEntity() {
        ReviewDto dto = new ReviewDto();
        dto.setId("xyz789");
        dto.setAuthor("Test");
        dto.setComment("Recensione");

        Review entity = mapper.fromDtoToEntity(dto);

        assertEquals(dto.getId(), entity.getId());
        assertEquals(dto.getAuthor(), entity.getAuthor());
        assertEquals(dto.getComment(), entity.getComment());
    }
}

