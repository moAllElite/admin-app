package com.groupeisi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<GlobalException> handleRequestException(RequestException e){
        GlobalException globalException =new GlobalException(e.getMessage(),e.getStatus(),LocalDateTime.now());
        return  new ResponseEntity<>(globalException,e.status);
    }
    @ExceptionHandler(value = {EntityNotExceptionsFound.class})
    public ResponseEntity<GlobalException> handleEntityNotExceptionFound(RequestException e){
        GlobalException globalException =new GlobalException(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
        return  new ResponseEntity<>(globalException,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<GlobalException> handleNumberFormatException(RequestException e){
        GlobalException globalException =new GlobalException(HttpStatus.BAD_REQUEST.getReasonPhrase(),HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return  new ResponseEntity<>(globalException,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalException> handleMethodArgumentNotValideException(RequestException ex){
        GlobalException globalException =new GlobalException("la valeur saisie est invalide",HttpStatus.BAD_REQUEST, LocalDateTime.now());
        return  new ResponseEntity<>(globalException,HttpStatus.BAD_REQUEST);
    }
}
