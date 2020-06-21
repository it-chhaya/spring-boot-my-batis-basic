package com.kshrd.articlerest_version2.service.impl;

import com.kshrd.articlerest_version2.repository.ArticleRepository;
import com.kshrd.articlerest_version2.repository.dto.ArticleDto;
import com.kshrd.articlerest_version2.rest.response.Messages;
import com.kshrd.articlerest_version2.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto insert(ArticleDto article) {
        boolean isInserted = articleRepository.insert(article);
        if (isInserted)
            return article;
        else
            return null;
    }

    @Override
    public List<ArticleDto> select() {
        return articleRepository.select();
    }

    @Override
    public ArticleDto selectByArticleId(String articleId) {

        ArticleDto articleDto = articleRepository.selectByArticleId(articleId);

        if (articleDto != null) {
            return articleRepository.selectByArticleId(articleId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Messages.Error.NO_RECORD_FOUND.value());
        }

    }
}
