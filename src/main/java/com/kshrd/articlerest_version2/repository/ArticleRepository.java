package com.kshrd.articlerest_version2.repository;

import com.kshrd.articlerest_version2.repository.dto.ArticleDto;
import com.kshrd.articlerest_version2.repository.provider.ArticleProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository {

    @Insert("INSERT INTO articles (article_id, title, description) " +
            "VALUES (#{articleId}, #{title}, #{description})")
    boolean insert(ArticleDto article);

    // Not using provider
    //@Select("SELECT * FROM articles")
    // Using provider
    @SelectProvider(value = ArticleProvider.class, method = "select")
    List<ArticleDto> select();


}
