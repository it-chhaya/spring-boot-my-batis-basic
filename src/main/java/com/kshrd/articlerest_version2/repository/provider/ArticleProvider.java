package com.kshrd.articlerest_version2.repository.provider;

import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String select() {
        return new SQL(){{
            SELECT("*");
            FROM("articles");
        }}.toString();
    }

    public String selectByFilter(String articleId, String title) {
        return new SQL(){{
            SELECT("*");
            FROM("articles");

            // Check condition
            if (articleId != null || !articleId.equals(""))
                WHERE("articleId = #{articleId}");
            else if (title != null || !title.equals(""))
                WHERE("title = #{title}");
            else
                WHERE();

        }}.toString();
    }

}
