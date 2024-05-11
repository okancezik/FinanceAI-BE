package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.DataResult;
import com.okancezik.financeai.core.utils.results.ErrorDataResult;
import com.okancezik.financeai.core.utils.results.SuccessDataResult;
import com.okancezik.financeai.service.abstracts.AuthService;
import com.okancezik.financeai.service.dto.requests.AuthenticationRequest;
import com.okancezik.financeai.service.dto.responses.AuthenticationResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthApi {

    private final AuthService authService;

    @PostMapping("/register")
    public DataResult<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request)
    {
        var data = this.authService.register(request);
        if(data!=null){
            return new SuccessDataResult<>(data,"Register successfully");
        }
        return new ErrorDataResult<>("Register operation failed");
    }

    @PostMapping("/login")
    public DataResult<AuthenticationResponse> login(@RequestBody AuthenticationRequest request,
                                        HttpServletResponse response)
    {
      var data =  this.authService.login(request,response);
        if(data!=null){
            return new SuccessDataResult<>(data,"Login successfully");
        }
        return new ErrorDataResult<>("Register operation failed");
    }
}
