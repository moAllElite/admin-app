package com.groupeisi.service;

import com.groupeisi.dto.AppRolesDto;
import com.groupeisi.exception.EntityNotExceptionsFound;
import com.groupeisi.exception.RequestException;
import com.groupeisi.mapping.AppRolesMapper;
import com.groupeisi.repositories.IAppRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class AppRoleService {
    private  IAppRoleRepository roleRepository;
    private   AppRolesMapper appRolesMapper;
    MessageSource messageSource;

    public AppRoleService(IAppRoleRepository roleRepository, AppRolesMapper appRolesMapper, MessageSource messageSource) {
        this.roleRepository = roleRepository;
        this.appRolesMapper =appRolesMapper;
        this.messageSource = messageSource;
    }

    @Transactional(readOnly = true)
    public List<AppRolesDto> getRoles(){
        return StreamSupport.stream(roleRepository.findAll()
                        .spliterator(),false)
                .map(appRolesMapper::toAppRolesEntity)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public AppRolesDto getRole(int id){
        return appRolesMapper.toAppRolesEntity(roleRepository.findById(id)
                .orElseThrow(()->
                        new EntityNotExceptionsFound( messageSource.
                                getMessage(
                                        "role.notfound",new Object[]{id}, Locale.getDefault()
                                )
                        )
                )
        );
    }
    @Transactional
    public AppRolesDto createAppRole(AppRolesDto appRolesDto){
        return appRolesMapper.toAppRolesEntity(roleRepository.save(
                appRolesMapper.fromAppUserEntity(appRolesDto))
        );
    }
    @Transactional
    public AppRolesDto updateAppRole(int id, AppRolesDto appRolesDto){
        return roleRepository.findById(id)
                .map(entity->{
                   appRolesDto.setId(id);
                    return appRolesMapper.toAppRolesEntity(
                            roleRepository.save(appRolesMapper.fromAppUserEntity(appRolesDto)
                            )
                    );
                })
                .orElseThrow(()->
                           new EntityNotExceptionsFound(messageSource.getMessage
                                    ("role.notfound", new Object[]{id}, Locale.getDefault())

                            )

                );
    }
    @Transactional
    public void  deleteAppRole(int id){
       try {
           roleRepository.deleteById(id);
       }catch (Exception e){
           throw  new RequestException(
                   messageSource.getMessage(
                           "role.errordeletion",
                           new Object[]{id},
                           Locale.getDefault()
                   ),
                   HttpStatus.CONFLICT
           );

       }
    }
}
