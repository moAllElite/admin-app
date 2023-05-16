package com.groupeisi.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;


@Getter@Setter

@AllArgsConstructor
public class ApiException extends Exception{
       final String  message ;
      final        HttpStatus  status;
      final LocalDateTime timestamp;

}
