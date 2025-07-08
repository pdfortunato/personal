package com.personal.project.firstday.model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("reviews")
public class Review {

    @Id
    private String id;
    private String author;
    private String comment;
    private int rating;
    private long productId;
    private long userId;

    public Review(String id, String author, String comment, int rating, long productId, long userId) {
        this.id = id;
        this.author = author;
        this.comment = comment;
        this.rating = rating;
        this.productId = productId;
        this.userId = userId;
    }

    public Review() {}

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

    public void setId(String id) {
        this.id = id;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
