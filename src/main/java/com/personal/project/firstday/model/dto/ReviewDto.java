package com.personal.project.firstday.model.dto;

import jakarta.validation.constraints.NotNull;

public class ReviewDto {

    @NotNull
    private String id;
    private String comment;
    private int rating;
    @NotNull
    private long productId;
    @NotNull
    private long userId;

    public ReviewDto() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public long getProductId() {
        return productId;
    }
}
