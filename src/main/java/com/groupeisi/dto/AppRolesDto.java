package com.groupeisi.dto;


import com.groupeisi.entities.AppRoles;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import javax.management.relation.Role;


@Setter @Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppRolesDto {

    private int id;
    @NotNull(message = "le nom doit pas être null")
    private String nom;

    public static AppRolesDto fromAppRoleEntity(AppRoles appRoles){
        return AppRolesDto.builder()
                .id(appRoles.getId())
                .nom(appRoles.getNom())
                .build();
    }
    public static AppRoles toAppRolesEntity(AppRolesDto rolesDto){
        return AppRoles.builder()
                .id(rolesDto.getId())
                .nom(rolesDto.getNom())
                .build();
    }

}
