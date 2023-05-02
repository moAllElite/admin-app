package com.groupeisi.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor

public class GlobalException extends Exception{
    final String message ;
   final HttpStatus  status;
    final LocalDateTime timestamp;
}
