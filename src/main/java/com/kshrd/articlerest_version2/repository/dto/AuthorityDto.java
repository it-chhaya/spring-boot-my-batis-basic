package com.kshrd.articlerest_version2.repository.dto;

public class AuthorityDto {

    private int id;
    private String name;

    public AuthorityDto(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
