package com.groupeisi.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
@Data
@AllArgsConstructor
public class RequestException extends  RuntimeException{

    final String message;
    final HttpStatus status;

}
