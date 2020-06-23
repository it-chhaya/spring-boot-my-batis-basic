package com.kshrd.articlerest_version2.rest.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ApiUtils {

    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
