package com.example.smart_content_gen.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class ApplicationUtil {

    public static HttpEntity<Object> createRequest(Object obj, HttpHeaders httpHeaders){
        return new HttpEntity<>(obj, httpHeaders);
    }
}
