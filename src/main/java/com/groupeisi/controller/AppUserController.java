package com.groupeisi.controller;

import com.groupeisi.repositories.IAppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class AppUserController {
    private  IAppUserRepository userRepository;
 }
