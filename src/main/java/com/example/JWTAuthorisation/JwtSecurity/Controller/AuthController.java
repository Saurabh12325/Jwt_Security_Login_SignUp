package com.example.JWTAuthorisation.JwtSecurity.Controller;

import com.example.JWTAuthorisation.JwtSecurity.DTO.UserRegistrationRequest;
import com.example.JWTAuthorisation.JwtSecurity.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
  private UserService userService;


    @PostMapping("/Signup")
    public ResponseEntity<AuthenticationResponse> UserRegistration(@RequestBody UserRegistrationRequest request) {

        return ResponseEntity.ok(userService.userRegistration(request));
    }

    @PostMapping("/login")
    public  ResponseEntity<AuthenticationResponse> loginUser(@RequestBody UserRegistrationRequest request) {
        return ResponseEntity.ok(userService.loginUser(request));
    }
}

