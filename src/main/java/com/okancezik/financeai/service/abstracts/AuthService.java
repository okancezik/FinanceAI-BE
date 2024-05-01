package com.okancezik.financeai.service.abstracts;

import com.okancezik.financeai.service.dto.requests.AuthenticationRequest;
import com.okancezik.financeai.service.dto.responses.AuthenticationResponse;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

    AuthenticationResponse register(AuthenticationRequest authenticationRequest);

    AuthenticationResponse login(
            AuthenticationRequest authenticationRequest,
            HttpServletResponse response
    );
}
