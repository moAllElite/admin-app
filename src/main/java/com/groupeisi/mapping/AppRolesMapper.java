package com.groupeisi.mapping;

import com.groupeisi.dto.AppRolesDto;
import com.groupeisi.entities.AppRoles;
import org.mapstruct.Mapper;

@Mapper
public interface AppRolesMapper {
    AppRolesDto toAppRolesEntity(AppRoles appRoles);
    AppRoles fromAppUserEntity(AppRolesDto appRolesDto);
}
