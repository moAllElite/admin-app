package com.groupeisi.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {

    private int id;
    @NotNull(message = "le nom ne doit pas être null")
    private String nom;
    @NotNull(message = "la quantité ne doit pas être null")
    private double qteStock;


}
