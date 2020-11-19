package com.darkstar.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Duration;

public class Item {

    private String ref;
    private String name;
    private BigDecimal price;
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    @JsonProperty("estimated_completion_time")
    private Duration estimatedCompletionTime;

    /**
     * Get ref.
     **/
    public String getRef() {
        return ref;
    }

    public Item setRef(final String ref) {
        this.ref = ref;
        return this;
    }

    /**
     * Get name.
     **/
    public String getName() {
        return name;
    }

    public Item setName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * Get price.
     **/
    public BigDecimal getPrice() {
        return price;
    }

    public Item setPrice(final BigDecimal price) {
        this.price = price;
        return this;
    }

    /**
     * Get description.
     **/
    public String getDescription() {
        return description;
    }

    public Item setDescription(final String description) {
        this.description = description;
        return this;
    }

    /**
     * Get imageUrl.
     **/
    public String getImageUrl() {
        return imageUrl;
    }

    public Item setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    /**
     * Get estimatedCompletionTime.
     **/
    public Duration getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    public Item setEstimatedCompletionTime(final Duration estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
        return this;
    }
}
