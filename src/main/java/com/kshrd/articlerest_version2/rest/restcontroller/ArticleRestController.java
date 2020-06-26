package com.kshrd.articlerest_version2.rest.restcontroller;

import com.kshrd.articlerest_version2.repository.dto.ArticleDto;
import com.kshrd.articlerest_version2.rest.request.ArticleRequestModel;
import com.kshrd.articlerest_version2.rest.response.BaseApiResponse;
import com.kshrd.articlerest_version2.service.impl.ArticleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleRestController {

    private ArticleServiceImpl articleService;

    @Autowired
    public void setArticleService(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/articles")
    public ResponseEntity<BaseApiResponse<ArticleRequestModel>> insert(
            @RequestBody ArticleRequestModel article) {

        BaseApiResponse<ArticleRequestModel> response = new BaseApiResponse<>();

        // Validate ->
        ModelMapper mapper = new ModelMapper();
        ArticleDto articleDto = mapper.map(article, ArticleDto.class);

        // Give generated ID to result
        articleDto.setArticleId("qwertyuiojbfjkldfh");

        ArticleDto result = articleService.insert(articleDto);

        ArticleRequestModel result2 = mapper.map(result, ArticleRequestModel.class);

        response.setMessage("You have added article successfully");
        response.setData(result2);
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);

    }

    @GetMapping("/articles")
    public ResponseEntity<BaseApiResponse<List<ArticleRequestModel>>> select() {

        ModelMapper mapper = new ModelMapper();
        BaseApiResponse<List<ArticleRequestModel>> response =
                new BaseApiResponse<>();

        List<ArticleDto> articleDtoList = articleService.select();
        List<ArticleRequestModel> articles = new ArrayList<>();

        for (ArticleDto articleDto : articleDtoList) {
            articles.add(mapper.map(articleDto, ArticleRequestModel.class));
        }

        response.setMessage("You have found all articles successfully");
        response.setData(articles);
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

}
