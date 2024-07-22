package com.example.Doctor_Patient_Management;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception e) {
        return e.getMessage();
    }

    public static class InvalidFieldException extends RuntimeException {
        public InvalidFieldException(final String message){
            super(message);
        }
        public InvalidFieldException(final String message, Exception e){
            super(message + " , Error : " + e.getMessage());
        }
    }
}