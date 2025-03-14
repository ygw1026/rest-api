package com.nhnacademy.blogapi.common.advice;

import com.nhnacademy.blogapi.common.exception.CommonHttpException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE)
@ControllerAdvice
public class CommonAdvice {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<CommonErrorResponse> bindExceptionHandler(BindException e, HttpServletRequest httpServletRequest, Model model) {
        log.error(e.getMessage(), e);
//        String referer = httpServletRequest.getHeader("Referer");

        List<String> erros = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(error ->{
            if(error instanceof FieldError fieldError){
                erros.add("%s : %s".formatted(fieldError.getField(),fieldError.getDefaultMessage()));
            }
        });

        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(Strings.join(erros,','), HttpStatus.BAD_REQUEST.hashCode(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(commonErrorResponse);
    }

    @ExceptionHandler(CommonHttpException.class)
    public ResponseEntity<CommonErrorResponse> exceptionHandler(CommonHttpException e, HttpServletRequest httpServletRequest) {
        log.error(e.getMessage(), e);
        String referer = httpServletRequest.getHeader("Referer");
        CommonErrorResponse commonErrorResponse = new CommonErrorResponse(e.getMessage(), e.getStatusCode(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(e.getStatusCode()).body(commonErrorResponse);
    }

}
