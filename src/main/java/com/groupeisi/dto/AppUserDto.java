package com.groupeisi.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;



@Getter@Setter
@Builder
@AllArgsConstructor


public class AppUserDto {
    private int id;
    @NotNull(message = "le nom ne doit pas être null")
    private String nom ;
    @NotNull(message = "le prenom ne doit pas être null")
    private String prenom ;
    @NotNull(message = "le email ne doit pas être null")
    private String email;
    @NotNull(message = "le password ne doit pas être null")
    private String password;

}
