package com.groupeisi.dto;


import com.groupeisi.entities.AppRoles;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import javax.management.relation.Role;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppRolesDto {
    @Setter @Getter
    private int id;
    @NotNull(message = "l'id'ne doit pas être null")
    private String nom;

    public static AppRolesDto fromAppRoleEntity(AppRoles appRoles){
        return AppRolesDto.builder()
                .nom(appRoles.getNom())
                .build();
    }
    public static AppRoles toAppRolesEntity(AppRolesDto rolesDto){
        return AppRoles.builder()
                .nom(rolesDto.getNom())
                .build();
    }

}
