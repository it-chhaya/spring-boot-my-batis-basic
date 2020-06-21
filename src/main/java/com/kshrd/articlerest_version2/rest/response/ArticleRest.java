package com.kshrd.articlerest_version2.rest.response;

public class ArticleRest {

    private String title;
    private String description;

    public ArticleRest() {}

    public ArticleRest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ArticleRest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
