package com.groupeisi.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;



@Data
@Builder
@AllArgsConstructor

public class AppRolesDto {

    private int id;
    @NotNull(message = "l'id'ne doit pas être null")
    private String nom;

}
