package com.darkstar.service.model;

public abstract class User {

    private Integer uid;
    private String name;

    /**
     * Get uid.
     **/
    public final Integer getUid() {
        return uid;
    }

    public final User setUid(final Integer uid) {
        this.uid = uid;
        return this;
    }

    /**
     * Get name.
     **/
    public final String getName() {
        return name;
    }

    public final User setName(final String name) {
        this.name = name;
        return this;
    }
}
