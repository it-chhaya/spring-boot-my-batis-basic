package com.kshrd.articlerest_version2.rest.restcontroller;

import com.kshrd.articlerest_version2.repository.dto.ArticleDto;
import com.kshrd.articlerest_version2.rest.request.ArticleRequestModel;
import com.kshrd.articlerest_version2.rest.response.ArticleRest;
import com.kshrd.articlerest_version2.rest.response.ApiResponse;
import com.kshrd.articlerest_version2.rest.response.Messages;
import com.kshrd.articlerest_version2.service.impl.ArticleServiceImpl;
import com.kshrd.articlerest_version2.utils.DateTimeUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleRestController {

    private ArticleServiceImpl articleService;
    private DateTimeUtils dateTimeUtils;

    @Autowired
    public void setArticleService(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setDateTimeUtils(DateTimeUtils dateTimeUtils) {
        this.dateTimeUtils = dateTimeUtils;
    }

    @PostMapping("/articles")
    public ResponseEntity<ApiResponse<ArticleRequestModel>> insert(
            @RequestBody ArticleRequestModel article) {

        ApiResponse<ArticleRequestModel> response = new ApiResponse<>();

        // Validate ->

        ModelMapper mapper = new ModelMapper();
        ArticleDto articleDto = mapper.map(article, ArticleDto.class);

        // Give generated ID to result
        articleDto.setArticleId("qwertyuiojbfjkldfh");

        ArticleDto result = articleService.insert(articleDto);

        ArticleRequestModel result2 = mapper.map(result, ArticleRequestModel.class);

        response.setMessage("You have added article successfully");
        response.setData(result2);
        response.setStatusCode(HttpStatus.OK.value());
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);

    }

    @GetMapping("/articles")
    public ResponseEntity<ApiResponse<List<ArticleRequestModel>>> select() {

        ModelMapper mapper = new ModelMapper();
        ApiResponse<List<ArticleRequestModel>> response =
                new ApiResponse<>();

        List<ArticleDto> articleDtoList = articleService.select();
        List<ArticleRequestModel> articles = new ArrayList<>();

        for (ArticleDto articleDto : articleDtoList) {
            articles.add(mapper.map(articleDto, ArticleRequestModel.class));
        }

        response.setMessage("You have found all articles successfully");
        response.setData(articles);
        response.setStatusCode(HttpStatus.OK.value());
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/articles/{articleId}")
    public ResponseEntity<ApiResponse<ArticleRest>> selectByArticleId(
            @PathVariable String articleId) {

        ApiResponse<ArticleRest> response = new ApiResponse<>();
        ArticleDto articleDto;

        articleDto = articleService.selectByArticleId(articleId);

        ModelMapper mapper = new ModelMapper();
        ArticleRest articleRest = mapper.map(articleDto, ArticleRest.class);

        response.setSuccess(true);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage(Messages.Success.RECORD_FOUND.value());
        response.setTime(dateTimeUtils.getCurrentTimestamp());
        response.setData(articleRest);

        return ResponseEntity.ok(response);

    }

}
