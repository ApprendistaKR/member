package com.member.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class ApiLoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String queryString = request.getQueryString();
        String fullUri = (queryString == null)
                ? request.getRequestURI()
                : request.getRequestURI() + "?" + queryString;

        log.info("[API - LOG] {} {}", request.getMethod(), fullUri);
        return true;
    }
}