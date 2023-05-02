package com.groupeisi.mapping;

import com.groupeisi.dto.AppUserDto;
import com.groupeisi.entities.AppUser;
import org.mapstruct.Mapper;

@Mapper
public interface AppUserMapper {
    AppUserDto toAppUserEntity(AppUser appUser);
    AppUser fromAppUser(AppUserDto appUserDto);
}
