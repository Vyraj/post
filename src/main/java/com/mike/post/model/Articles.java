package com.mike.post.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Articles<News> {

    private News[] array;

    @JsonProperty("articles")
    public News[] getArray() {
        return array;
    }
}
