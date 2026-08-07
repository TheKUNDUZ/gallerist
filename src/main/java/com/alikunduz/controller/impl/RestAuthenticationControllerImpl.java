package com.alikunduz.controller.impl;

import com.alikunduz.controller.IRestAuthenticationController;
import com.alikunduz.controller.RestBaseController;
import com.alikunduz.controller.RootEntity;
import com.alikunduz.dto.AuthRequest;
import com.alikunduz.dto.AuthResponse;
import com.alikunduz.dto.DtoUser;
import com.alikunduz.dto.RefreshTokenRequest;
import com.alikunduz.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;


    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.authenticate(input));
    }

    @PostMapping("/refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input) {
        return ok(authenticationService.refreshToken(input));
    }
}
