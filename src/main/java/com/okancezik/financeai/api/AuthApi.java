package com.okancezik.financeai.api;

import com.okancezik.financeai.service.abstracts.AuthService;
import com.okancezik.financeai.service.dto.requests.AuthenticationRequest;
import com.okancezik.financeai.service.dto.responses.AuthenticationResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthenticationResponse register(
            @RequestBody AuthenticationRequest request)
    {
        return this.authService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request,
                                        HttpServletResponse response)
    {
      return  this.authService.login(request,response);
    }
}
