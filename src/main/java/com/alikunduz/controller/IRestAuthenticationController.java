package com.alikunduz.controller;

import com.alikunduz.dto.AuthRequest;
import com.alikunduz.dto.AuthResponse;
import com.alikunduz.dto.DtoUser;
import com.alikunduz.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
