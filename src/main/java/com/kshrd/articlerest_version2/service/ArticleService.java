package com.kshrd.articlerest_version2.service;

import com.kshrd.articlerest_version2.repository.dto.ArticleDto;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ArticleService {

    // Insert article
    ArticleDto insert(ArticleDto article);

    // Select all articles
    List<ArticleDto> select();

    // Select an article by article id
    ArticleDto selectByArticleId(String articleId) throws ResponseStatusException;

}
