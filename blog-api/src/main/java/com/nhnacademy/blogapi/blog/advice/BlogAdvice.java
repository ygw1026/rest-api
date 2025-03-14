package com.nhnacademy.blogapi.blog.advice;

import com.nhnacademy.blogapi.blog.controller.BlogController;
import com.nhnacademy.blogapi.blog.exception.AlreadyExistBlogFidException;
import com.nhnacademy.blogapi.blog.exception.BlogNotFoundException;
import com.nhnacademy.blogapi.common.error.CommonException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = {BlogController.class})
public class BlogAdvice {
    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<CommonException> blogNotFoundExceptionHandler(
            BlogNotFoundException blogNotFoundException,
            HttpServletRequest request
    ){

        CommonException commonException = new CommonException(
                blogNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI()
        );

        return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(commonException);
    }

    @ExceptionHandler(AlreadyExistBlogFidException.class)
    public ResponseEntity<CommonException> AlreadyExistBlogFidExceptionHandler(
            AlreadyExistBlogFidException alreadyExistBlogFidException,
            HttpRequest request
    ){

        CommonException commonException = new CommonException(
                alreadyExistBlogFidException.getMessage(),
                HttpStatus.CONFLICT.value(),
                request.getURI().toString()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(commonException);
    }
}
