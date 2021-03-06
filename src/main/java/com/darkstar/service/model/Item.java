package com.darkstar.service.model;

import java.math.BigDecimal;

public class Item {

    private String ref;
    private String name;
    private BigDecimal price;
    private String description;
    private String imageUrl;
    private String estimatedCompletionTime;

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
    public String getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    public Item setEstimatedCompletionTime(final String estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
        return this;
    }
}
