package com.kshrd.articlerest_version2.rest.request;

public class ArticleRequestModel {

    private String title;
    private String description;

    public ArticleRequestModel() {}

    public ArticleRequestModel(String title, String description) {
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
        return "ArticleRequestModel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
