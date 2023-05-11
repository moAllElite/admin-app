package com.groupeisi.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;


@Data

@AllArgsConstructor
public class ApiException extends Exception{
       final String  message ;
      final        HttpStatus  status;
      final LocalDateTime timestamp;

}
