package com.groupeisi.controller;

import com.groupeisi.dto.AppRolesDto;
import com.groupeisi.service.AppRoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/roles")
@AllArgsConstructor
@RestController
public class AppRoleController {
    private AppRoleService roleService;
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppRolesDto saveRole(
        @Valid
        @RequestBody AppRolesDto appRolesDto
    ){
        return roleService.createAppRole(appRolesDto);
    }
    @GetMapping
    public List<AppRolesDto> getAppRoles(){
        return  roleService.getRoles();
    }
    @GetMapping("{id}")
    public AppRolesDto getRole(
            @PathVariable("id") int id
    ){
        return roleService.getRole(id);
    }
    @PutMapping("{id}")
    public AppRolesDto updateRole(
            @PathVariable("id")
            int id,
            @Valid
            @RequestBody AppRolesDto appRolesDto
    ){
        return roleService.updateAppRole(id, appRolesDto);
    }
    @DeleteMapping("{id}")
    public void deleteRole(
            @PathVariable("id")
            int id
    ){
        roleService.deleteAppRole(id);
    }
}
