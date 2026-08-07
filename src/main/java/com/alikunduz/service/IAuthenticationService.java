package com.alikunduz.service;

import com.alikunduz.dto.AuthRequest;
import com.alikunduz.dto.AuthResponse;
import com.alikunduz.dto.DtoUser;
import com.alikunduz.dto.RefreshTokenRequest;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
