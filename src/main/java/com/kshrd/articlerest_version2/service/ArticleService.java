package com.kshrd.articlerest_version2.service;

import com.kshrd.articlerest_version2.repository.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto insert(ArticleDto article);
    List<ArticleDto> select();

}
