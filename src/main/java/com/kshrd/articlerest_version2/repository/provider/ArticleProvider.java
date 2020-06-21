package com.kshrd.articlerest_version2.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String select() {
        return new SQL(){{
            SELECT("*");
            FROM("articles");
        }}.toString();
    }

    public String selectByArticleId(String articleId) {
        return new SQL() {{
            SELECT("*");
            FROM("articles");
            WHERE("article_id = #{articleId}");
        }}.toString();
    }

}
