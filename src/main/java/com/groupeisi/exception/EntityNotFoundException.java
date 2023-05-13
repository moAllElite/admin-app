package com.groupeisi.exception;

import lombok.*;




@AllArgsConstructor
public class EntityNotFoundException extends RuntimeException {
       private final String message;
}
