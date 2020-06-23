package com.kshrd.articlerest_version2.rest.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DateTimeUtils {

    public Timestamp getCurrentTime() {
        return new Timestamp(System.currentTimeMillis());
    }

}
