package com.nhnacademy.blogapi.common.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommonErrorResponse {
    private final String message;
    private final int statusCode;
    private final String uri;
}
