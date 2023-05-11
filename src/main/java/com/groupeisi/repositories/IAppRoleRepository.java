package com.groupeisi.repositories;

import com.groupeisi.entities.AppRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppRoleRepository extends JpaRepository<AppRoles,Integer> {

}
