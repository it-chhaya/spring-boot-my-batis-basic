package com.kshrd.articlerest_version2.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DateTimeUtils {

    public Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

}
