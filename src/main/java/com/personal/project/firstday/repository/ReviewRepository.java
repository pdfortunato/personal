package com.personal.project.firstday.repository;

import com.personal.project.firstday.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
