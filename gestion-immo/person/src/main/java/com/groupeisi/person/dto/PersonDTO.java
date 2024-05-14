package com.groupeisi.person.dto;

import com.groupeisi.person.entities.PersonType;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public record PersonDTO(
        Long id,
        String fullName,
        String email,
        LocalDate birthDate,
        PersonType personType
)
{
}
