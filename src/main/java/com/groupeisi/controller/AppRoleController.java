package com.groupeisi.controller;

import com.groupeisi.dto.AppRolesDto;
import com.groupeisi.service.AppRolesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/roles")
@AllArgsConstructor
@RestController
public class AppRoleController {
    private AppRolesService roleService;
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRolesDto saveRole(
        @Valid
        @RequestBody AppRolesDto appRolesDto
    ){
        return roleService.createAppRoles(appRolesDto);
    }
   @GetMapping
    public List<AppRolesDto> getAppRoles(){
        return  roleService.getAppRoles();
    }
    @GetMapping("/{id}")
    public AppRolesDto getRole(
            @PathVariable("id") int id
    ){
        return roleService.getAppRole(id);
    }
    @PutMapping("/{id}")
    public AppRolesDto updateRole(
            @PathVariable("id")
            int id,
            @Valid
            @RequestBody AppRolesDto appRolesDto
    ){
        return roleService.updateAppRoles(id, appRolesDto);
    }
    @DeleteMapping("{id}")
    public void deleteRole(
            @PathVariable("id")
            int id
    ){
        roleService.deleteAppRoles(id);
    }
}
