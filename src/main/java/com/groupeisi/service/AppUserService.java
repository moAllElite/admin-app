package com.groupeisi.service;

import com.groupeisi.dto.AppUserDto;
import com.groupeisi.exception.EntityNotExceptionsFound;
import com.groupeisi.exception.RequestException;
import com.groupeisi.mapping.AppUserMapper;
import com.groupeisi.repositories.IAppUserRepository;
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
public class AppUserService {
    private IAppUserRepository userRepository;
    private AppUserMapper userMapper;
    public static final String USERNOTFOUND="user.notfound";
    MessageSource messageSource;
    @Transactional
    public AppUserDto createAppRole(AppUserDto appUserDto){
        return  userMapper.toAppUserEntity(userRepository.save(
            userMapper.fromAppUser(appUserDto)
            )
        );
    }
    @Transactional
    public AppUserDto updateUser(int id,AppUserDto appUserDto){
        return userRepository.findById(id)
                .map(entity->{
                    appUserDto.setId(id);
                    return  userMapper.toAppUserEntity(
                            userRepository.save(userMapper.fromAppUser(appUserDto)
                            )
                    );
                })
                .orElseThrow(()->new EntityNotExceptionsFound(
                        messageSource.getMessage(
                        USERNOTFOUND,new Object[]{id}, Locale.getDefault())
                        )
                );
    }
    @Transactional(readOnly = true)
    public List<AppUserDto> getUsers(){
        return StreamSupport
                .stream(
                    userRepository.findAll()
                    .spliterator(),false)
                    .map(userMapper::toAppUserEntity)
                    .collect(Collectors.toList()
                );
    }
    @Transactional(readOnly = true)
    public AppUserDto getUserById(int id){
        /**
         * transform from dto to entity
         */
        return  userMapper.toAppUserEntity(userRepository.findById(id)
                .orElseThrow(()->new EntityNotExceptionsFound(messageSource.getMessage(
                        USERNOTFOUND,new Object[]{id},Locale.getDefault())
                        )
                )
        );
    }
    @Transactional(readOnly = true)
    public AppUserDto getUserByEmail(String email){
        /**
         * transform from dto to entity
         */
        return  userMapper.toAppUserEntity(userRepository.findByEmail(email)
                .orElseThrow(()->new EntityNotExceptionsFound(messageSource.getMessage(
                                USERNOTFOUND,new Object[]{email},Locale.getDefault())
                        )
                )
        );
    }
    @Transactional
    public void deleteUser(int id){
        try {
            userRepository.deleteById(id);
        }catch (Exception e){
            throw new RequestException(
                    messageSource.getMessage(
                            "user.errordeletion",
                            new Object[]{id},
                            Locale.getDefault()
                    ),
                    HttpStatus.CONFLICT
            );
        }
    }
    @Transactional
    public void deleteUserByEmail(String email){
        try {
            userRepository.deleteAppUserByEmail(email);
        }catch (Exception e){
            throw new RequestException(
                    messageSource.getMessage(
                            "user.errordeletion",
                            new Object[]{email},
                            Locale.getDefault()
                    ),
                    HttpStatus.CONFLICT
            );
        }
    }

}
