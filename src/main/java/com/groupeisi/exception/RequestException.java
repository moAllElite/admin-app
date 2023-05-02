package com.groupeisi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class RequestException extends  RuntimeException{
    final String message;
    final HttpStatus status;
}
