package com.mike.post.controller;

import com.mike.post.output.WriterToFile;
import com.mike.post.repository.NewsRepository;
import com.mike.post.model.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsRepository newsRepository;

    private final WriterToFile writerToFile;

    @RequestMapping(value= "/news")
    public String home() {
        final News[] newsArray = newsRepository.getNewsByCountryAndCategory();
        writerToFile.writeNewsToFile(newsArray);
        return "home";
    }
}
