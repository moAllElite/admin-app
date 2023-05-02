package com.groupeisi.exception;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@RequiredArgsConstructor

public class EntityNotExceptionsFound extends RuntimeException {
    final   String message;
}
