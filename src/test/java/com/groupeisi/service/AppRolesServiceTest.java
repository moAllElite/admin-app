package com.groupeisi.service;

import com.groupeisi.dto.AppRolesDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AppRolesServiceTest {
    @Autowired
    private AppRolesService appRolesService;


    @Test
    public void getAppRoles() {
    }

    @Test
    public void getAppRole() {
    }

    @Test
    public void createAppRoles() {
        AppRolesDto appRoles=new AppRolesDto();
        appRoles.setNom("ROLE_ADMIN");
        AppRolesDto appRolesSave=appRolesService.createAppRoles(
                appRoles
        );
        Assertions.assertNotNull(appRolesSave);
    }

    @Test
    public void updateAppRoles() {
    }

    @Test
    public void deleteAppRoles() {
    }
}