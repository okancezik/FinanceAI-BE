package com.okancezik.financeai.service.concretes;

import com.okancezik.financeai.core.security.JwtTokenService;
import com.okancezik.financeai.core.utils.mappers.ModelMapperService;
import com.okancezik.financeai.entity.concretes.User;
import com.okancezik.financeai.repository.abstracts.UserRepository;
import com.okancezik.financeai.service.abstracts.AuthService;
import com.okancezik.financeai.service.dto.requests.AuthenticationRequestModel;
import com.okancezik.financeai.service.dto.responses.AuthenticationResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {

    private final UserRepository repository;
    private final JwtTokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapperService mapperService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseModel register(AuthenticationRequestModel authenticationRequest) {
        User user = mapperService.forRequest().map(authenticationRequest, User.class);
        user.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
        repository.save(user);
        String jwt = tokenService.generateToken(user);
        var data =  AuthenticationResponseModel
                .builder()
                .username(user.getUsername())
                .token(jwt)
                .build();
        return data;
    }

    @Override
    public AuthenticationResponseModel login(
            AuthenticationRequestModel authenticationRequest,
            HttpServletResponse response
    )
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );

        var user = repository.findByUsername(authenticationRequest.getUsername()).orElseThrow();
        String jwt = tokenService.generateToken(user);
        ResponseCookie cookie =
                ResponseCookie.from("accessToken",jwt)
                        .httpOnly(true)
                        .secure(false)
                        .path("/")
                        .maxAge(1800)
                        .build();
        response.addHeader(HttpHeaders.SET_COOKIE,cookie.toString());
        var data =  AuthenticationResponseModel
                .builder()
                .username(user.getUsername())
                .token(jwt)
                .build();
        return data;
    }

    @Override
    public boolean logOut(HttpServletRequest request,HttpServletResponse response) {
        ResponseCookie cookie =
                ResponseCookie.from("accessToken",null)
                        .httpOnly(true)
                        .secure(false)
                        .maxAge(0)
                        .build();
        response.addHeader(HttpHeaders.SET_COOKIE,cookie.toString());
        return true;
    }
}
