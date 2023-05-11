package com.groupeisi.exception;

import lombok.*;



@RequiredArgsConstructor
@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {
       private final String message;
}
