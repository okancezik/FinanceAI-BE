package com.okancezik.financeai.api;

import com.okancezik.financeai.core.utils.results.DataResult;
import com.okancezik.financeai.core.utils.results.ErrorDataResult;
import com.okancezik.financeai.core.utils.results.SuccessDataResult;
import com.okancezik.financeai.service.abstracts.AuthService;
import com.okancezik.financeai.service.dto.requests.AuthenticationRequestModel;
import com.okancezik.financeai.service.dto.responses.AuthenticationResponseModel;
import jakarta.servlet.http.HttpServletRequest;
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
    public DataResult<AuthenticationResponseModel> register(
            @RequestBody AuthenticationRequestModel request)
    {
        var data = this.authService.register(request);
        if(data!=null){
            return new SuccessDataResult<>(data,"Register successfully");
        }
        return new ErrorDataResult<>("Register operation failed");
    }

    @PostMapping("/login")
    public DataResult<AuthenticationResponseModel> login(@RequestBody AuthenticationRequestModel request,
                                                         HttpServletResponse response)
    {
      var data =  this.authService.login(request,response);
        if(data!=null){
            return new SuccessDataResult<>(data,"Login successfully");
        }
        return new ErrorDataResult<>("Register operation failed");
    }

    @PostMapping("/logout")
    public DataResult<Boolean> logout(HttpServletRequest request,HttpServletResponse response)
    {
        var data =  this.authService.logOut(request,response);
        if(data){
            return new SuccessDataResult<>("Logout successfully");
        }
        return new ErrorDataResult<>("Logout operation failed");
    }
}
