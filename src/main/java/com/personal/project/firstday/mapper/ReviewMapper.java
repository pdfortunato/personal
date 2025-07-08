package com.personal.project.firstday.mapper;

import com.personal.project.firstday.model.Review;
import com.personal.project.firstday.model.dto.ReviewDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDto fromEntityToDto(Review review);
    Review fromDtoToEntity(ReviewDto reviewDto);

    List<ReviewDto> fromEntityToDto(List<Review> reviews);
    List<Review> fromDtoToEntity(List<ReviewDto> reviewDtos);

}
