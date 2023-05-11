package com.groupeisi.service;


import com.groupeisi.entities.AppRoles;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.groupeisi.repositories.IAppRoleRepository;
import com.groupeisi.dto.AppRolesDto;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class AppRolesService {
    private IAppRoleRepository iAppRolesRepository;

    MessageSource messageSource;



    @Transactional(readOnly = true)
    public List<AppRolesDto>  getAppRoles() {
        return iAppRolesRepository.findAll().stream()
                .map(AppRolesDto::fromAppRoleEntity)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AppRolesDto getAppRole(int id) {
        return AppRolesDto.fromAppRoleEntity(
                AppRolesDto.toAppRolesEntity(iAppRolesRepository.findById(id)
                        .map(AppRolesDto::fromAppRoleEntity)
               .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("role.notfound",
                                new Object[]{id},
                                Locale.getDefault() ))
               )
            )
        );
    }

    @Transactional
    public AppRolesDto createAppRoles(AppRolesDto appRolesDto) {

         AppRoles roles=AppRolesDto.toAppRolesEntity(appRolesDto);
         return AppRolesDto.fromAppRoleEntity(iAppRolesRepository.save(roles));

    }

    @Transactional
    public  AppRolesDto updateAppRoles(int id, AppRolesDto appRolesDto) {
        return iAppRolesRepository.findById(id)
                .map(entity-> {
                    appRolesDto.setId(id);
                    AppRoles  roles=AppRolesDto.toAppRolesEntity(appRolesDto);
                    return AppRolesDto.fromAppRoleEntity(
                            iAppRolesRepository.save(roles)
                    );
                })
                .orElseThrow((() -> new EntityNotFoundException(messageSource.getMessage("role.notfound",
                        new Object[]{id},
                        Locale.getDefault() )))
                );
                }
    @Transactional
    public void deleteAppRoles(int id) {
        try {
            iAppRolesRepository.deleteById(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}