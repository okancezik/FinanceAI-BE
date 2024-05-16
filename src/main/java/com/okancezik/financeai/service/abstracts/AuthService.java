package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AuthenticationRequestModel;
import com.okancezik.financeai.service.dto.responses.AuthenticationResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    AuthenticationResponseModel register(AuthenticationRequestModel authenticationRequest);

    AuthenticationResponseModel login(
            AuthenticationRequestModel authenticationRequest,
            HttpServletResponse response
    );

    boolean logOut(HttpServletRequest request,HttpServletResponse response);
}
