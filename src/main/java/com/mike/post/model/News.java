package com.mike.post.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class News {

    private String author;

    private String title;

    private String description;

    @Override
    public String toString() {
        return "title: "+title+"\t\t description: "+description+"\t\t author: "+author+"";
    }
}
