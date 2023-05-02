package com.groupeisi.repositories;

import com.groupeisi.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAppUserRepository extends JpaRepository<AppUser,Integer> {
    @Query("select  u from  AppUser  u where  u.email=:email")
    Optional  <AppUser> findByEmail(String email);
    @Query("DELETE  FROM AppUser u WHERE u.email=:email")
    Optional <AppUser> deleteAppUserByEmail(String email);

}
