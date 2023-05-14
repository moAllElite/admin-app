package com.groupeisi.service;

import com.groupeisi.dto.AppRolesDto;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)

@SpringBootTest
public class AppRolesServiceTest {
    @Autowired
    private  AppRolesService appRolesService;

    /**
     * return length of list roles
     */
    @Test
    public void getAppRoles() {
        List<AppRolesDto> appRolesList=appRolesService.getAppRoles();
        int expentedLength=3;
        int length=appRolesList.size();
        Assertions.assertEquals(length,expentedLength);
    }

    @Test
    public void getAppRole() {
        AppRolesDto appRolesDto=appRolesService.getAppRole(1);
        Assertions.assertNotNull(appRolesDto);
    }

    @Test
    public void createAppRoles() {
        AppRolesDto appRoles=new AppRolesDto();
        appRoles.setNom("ROLE_GARDE");
        AppRolesDto appRolesSave=appRolesService.createAppRoles(
                appRoles
        );
        Assertions.assertNotNull(appRolesSave);
    }

    @Test
    public void updateAppRoles() {
        String expentedRole="ROLE_ADMIN";
        AppRolesDto appRoles=new AppRolesDto();
        appRoles.setNom("ROLE_ADMIN");
        AppRolesDto appRoleSave=appRolesService.updateAppRoles(1,appRoles);
        Assertions.assertEquals(appRoleSave.getNom(),expentedRole);
    }

    @Test
    public void deleteAppRoles() {
        appRolesService.deleteAppRoles(3);
        Assertions.assertTrue(true);
        System.out.println("le test s'est bien passé");
    }
    @Test
    public void operation(){
        int val1=1;
        int val2=2;
        int val3=val1+val2;
        int result=3;
        Assertions.assertEquals(val3,result);
    }
}