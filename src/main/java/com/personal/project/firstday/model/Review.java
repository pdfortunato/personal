package com.personal.project.firstday.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reviews")
public class Review {

    @Id
    private String id;
    private String comment;
    private int rating;
    private long productId;
    private long userId;

    public Review(String id, String comment, int rating, long productId, long userId) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.productId = productId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }
    public String getComment() {
        return comment;
    }
    public int getRating() {
        return rating;
    }
    public long getProductId() {
        return productId;
    }
    public long getUserId() {
        return userId;
    }
}
