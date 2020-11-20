package com.darkstar.service.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long uid;
    private String customer;
    private String assignee;
    private BigDecimal totalPrice;
    private String state;
    private List<Item> items;

    /**
     * Get uid.
     **/
    public Long getUid() {
        return uid;
    }

    public Order setUid(final Long uid) {
        this.uid = uid;
        return this;
    }

    /**
     * Get customer.
     **/
    public String getCustomer() {
        return customer;
    }

    public Order setCustomer(final String customer) {
        this.customer = customer;
        return this;
    }

    /**
     * Get assignee.
     **/
    public String getAssignee() {
        return assignee;
    }

    public Order setAssignee(final String assignee) {
        this.assignee = assignee;
        return this;
    }

    /**
     * Get totalPrice.
     **/
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Order setTotalPrice(final BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    /**
     * Get state.
     **/
    public String getState() {
        return state;
    }

    public Order setState(final String state) {
        this.state = state;
        return this;
    }

    /**
     * Get items.
     **/
    public List<Item> getItems() {
        return items;
    }

    public Order setItems(final List<Item> items) {
        this.items = items;
        return this;
    }
}
