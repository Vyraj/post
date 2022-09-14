package com.mike.post.repository;

import com.mike.post.model.Articles;
import com.mike.post.model.News;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class NewsRepository {

    private final RestTemplate restTemplate;

    public News[] getNewsByCountryAndCategory() {
        String url = "https://newsapi.org/v2/top-headlines?country=pl&category=business&pageSize=70&apiKey=5b7f6c7ee2f5468d9ad9b62093944571";
        return getNews(restTemplate, url);
    }

    private News[] getNews(RestTemplate restTemplate, String url) {
        return Objects.requireNonNull(restTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY,
                new ParameterizedTypeReference<Articles<News>>() {
                }).getBody()).getArray();
    }
}
